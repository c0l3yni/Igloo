import { BuildSpec, Project } from "aws-cdk-lib/aws-codebuild";
import { Repository } from "aws-cdk-lib/aws-codecommit";
import { CodeBuildProject } from "aws-cdk-lib/aws-events-targets";
import { Construct } from "constructs";

interface SourceControlArgs {
  repositoryName: string;
  bucketName: string;
  distributionId: string;
}

export class SourceControl {
  scope: Construct;
  args: SourceControlArgs;

  repo: Repository;

  constructor(scope: Construct, args: SourceControlArgs) {
    this.scope = scope;
    this.args = args;
    this.initialize();
  }

  private initialize() {
    this.initRepo();
    this.initDevelopBuild();
  }

  private initRepo() {
    this.repo = new Repository(this.scope, "sourceRepo", {
      repositoryName: this.args.repositoryName,
      description: `Source control repositry for RWP: ${this.args.repositoryName}`,
    });
  }

  private initDevelopBuild() {
    const buildProject = new Project(this.scope, "developBuildProject", {
      buildSpec: BuildSpec.fromObject({
        phases: {
          install: {
            commands: ["cd application/web/source", "npm install"],
          },
          build: {
            commands: ["npm run build"],
          },
          postBuild: [
            `aws s3 sync build/ s3://${this.args.bucketName}`,
            `aws cloudfront create-invalidation --distribution-id ${this.args.distributionId} --paths \"/*\"`,
          ],
        },
      }),
    });

    this.repo.onCommit("commitDevelop", {
      target: new CodeBuildProject(buildProject),
      branches: ["develop"],
    });
  }
}
