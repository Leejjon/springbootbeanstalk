Based on the tutorial: https://dzone.com/articles/using-cloudformation-to-set-up-scalable-apps

To run spring boot
Run ./gradlew runBoot

To build the project
Run ./gradlew build

Pick a stack with `aws beanstalk list-available-solution-stacks |grep Corretto`, mine is "64bit Amazon Linux 2 v3.2.12 running Corretto 11" and update it in aws/beanstalkcloudformation.template

Create beanstak application, name: springboot-kotlin-beanstalk

https://mydeveloperplanet.com/2020/10/21/how-to-deploy-a-spring-boot-app-to-aws-elastic-beanstalk/

eb init
eb create -s

In this process, the eb cli generates a role called aws-elasticbeanstalk-service-role

```
{
    "Version": "2012-10-17",
        "Statement": [
        {
        "Sid": "VisualEditor0",
        "Effect": "Allow",
        "Action": [
        "secretsmanager:GetRandomPassword",
        "secretsmanager:GetResourcePolicy",
        "secretsmanager:GetSecretValue",
        "secretsmanager:DescribeSecret",
        "secretsmanager:ListSecretVersionIds",
        "secretsmanager:ListSecrets"
        ],
        "Resource": "*"
        }
    ]
}
```

eb deploy


