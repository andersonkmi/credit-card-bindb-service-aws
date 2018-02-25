package org.sharpsw.dataproc

object AWSLambdaEnvVars {
  val BinDbSqsUrl = "BINDB_SQS_URL"
  val BinDbSqsUrlDefault = "https://sqs.us-east-1.amazonaws.com/970221509170/csv-data-processor"

  val LongPoolingWait = "LONG_POOLING_WAIT"
  val LongPoolingWaitDefault = "0"

  val MaxNumberOfMessages = "MAX_NUMBER_MESSAGES"
  val MaxNumberOfMessagesDefault = "10"

  val IterationsCount = "ITERATIONS_COUNT"
  val IterationsCountDefault = "2"

  val MetricDimensionName = "METRIC_DIMENSION_NAME"

  val MetricNamespace = "METRIC_NAMESPACE"

  val BinDbDynamoTable = "BINDB_RECORD_TABLE"
  val BinDbDynamoTableDefault = "BinDBRecord"
}
