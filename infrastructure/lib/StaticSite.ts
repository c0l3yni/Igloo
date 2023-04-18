import { Distribution, ErrorResponse } from "aws-cdk-lib/aws-cloudfront";
import { S3Origin } from "aws-cdk-lib/aws-cloudfront-origins";
import { Bucket } from "aws-cdk-lib/aws-s3";
import { Construct } from "constructs";

export class StaticSite {
  scope: Construct;
  siteBucket: Bucket;
  distribution: Distribution;

  constructor(scope: Construct) {
    this.scope = scope;
    this.initialize();
  }

  private initialize() {
    this.initBucket();
    this.initDistro();
  }

  private initBucket() {
    this.siteBucket = new Bucket(this.scope, "staticSiteBucket");
  }

  private initDistro() {
    const errorResponse: ErrorResponse = {
      httpStatus: 403,

      responseHttpStatus: 200,
      responsePagePath: "/index.html",
    };

    this.distribution = new Distribution(this.scope, "staticSiteDistribution", {
      defaultBehavior: { origin: new S3Origin(this.siteBucket, { originPath: "/build" }) },
      errorResponses: [errorResponse],
    });
  }

  public getSiteBucket() {
    return this.siteBucket;
  }

  public getDistribution() {
    return this.distribution;
  }
}
