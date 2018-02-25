# credit card bindb service - aka Sakura
Project using AWS Lambda and Scala for CSV processing and loading into DynamoDB with bindb information (based on BinDB csv file)

# Modules

This project is composed of the following modules so far:
- bindb-consumer-aws-lambda: responsible for consuming the records sent to Kinesis/SQS and loading them into DynamoDB
- csv-reader-aws-lambda: responsible for reading the CSV file uploaded to S3 and splitting it into messages for SQS/Kinesis

# High-level Architecture

![alt text](https://github.com/andersonkmi/credit-card-bindb-service-aws/img/architecture.jpg "Architecture")