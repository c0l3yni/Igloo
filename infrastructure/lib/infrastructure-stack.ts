import * as cdk from "aws-cdk-lib";
import { Construct } from "constructs";
import { SourceControl } from "./SourceControl";
import { StaticSite } from "./StaticSite";

export class InfrastructureStack extends cdk.Stack {
  staticSite: StaticSite;
  sourceControl: SourceControl;

  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    this.initialize();
  }

  private initialize() {
    this.initStaticSite();
    this.initSourceControl();
  }

  private initStaticSite() {
    this.staticSite = new StaticSite(this);
  }

  private initSourceControl() {
    this.sourceControl = new SourceControl(this, {
      repositoryName: "IglooRepo",
      bucketName: this.staticSite.getSiteBucket().bucketName,
      distributionId: this.staticSite.getDistribution().distributionId,
    });
  }
}
