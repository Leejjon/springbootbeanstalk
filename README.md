Based on the tutorial: https://dzone.com/articles/using-cloudformation-to-set-up-scalable-apps

To run spring boot
Run ./gradlew runBoot

To build the project
Run ./gradlew build

Create an S3 bucket in aws, mine is called springboot-kotlin-beanstalkbucket

Pick a stack with `aws beanstalk list-available-solution-stacks |grep Corretto`, mine is "64bit Amazon Linux 2 v3.2.12 running Corretto 11" and update it in aws/beanstalkcloudformation.template

Upload the jar to the s3 bucket
aws s3 cp build/libs/demo-0.0.1-SNAPSHOT.jar s3://springboot-kotlin-beanstalkbucket/beanstalk-deployment-1.0-SNAPSHOT.jar

Upload the cloudformation to the s3 bucket
aws s3 cp aws/beanstalkcloudformation.template s3://springboot-kotlin-beanstalkbucket/beanstalkspring.template

If we would run our cloudformation stack now it would fail due to:
https://stackoverflow.com/questions/53392302/environment-failed-to-launch-as-it-entered-terminated-state

So let's create a role
Go to IAM -> Roles
Click new role
Select EC2
Add the AWSElasticBeanstalkWebTier
Name it aws-elasticbeanstalk-ec2-role

Create the cloudformation stack
aws cloudformation create-stack --stack-name SpringBeanStalk --parameters ParameterKey=SourceCodeBucket,ParameterValue=springboot-kotlin-beanstalkbucket --template-url https://s3.amazonaws.com/springboot-kotlin-beanstalkbucket/beanstalkspring.template 



