# Sakura MK I - Credit card bindb service
Project using AWS Lambda and Scala for CSV processing and loading into DynamoDB with bindb information (based on BinDB csv file)

# Modules

This project is composed of the following modules so far:
- api-gw-aws-lambda: Lambdas used by API gateway.
- bindb-consumer-aws-lambda: responsible for consuming the records sent to Kinesis/SQS and loading them into DynamoDB
- sakura-csv-reader-aws-lambda: responsible for reading the CSV file uploaded to S3 and splitting it into messages for SQS. It can be found at https://github.com/andersonkmi/sakura-csv-reader-aws-lambda.
- custom-auth-aws-lambda: custom authorizer to be used with API gateway.

# High-level Architecture

![alt text](https://github.com/andersonkmi/credit-card-bindb-service-aws/raw/master/img/architecture.jpg "Architecture")

# Future improvements
- Include Elasticache to save the bin information and change the API gateway to search for bins directly to it instead of DynamoDB (to save on costs of using DynamoDB).
