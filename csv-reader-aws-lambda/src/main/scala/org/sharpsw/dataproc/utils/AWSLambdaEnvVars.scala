package org.sharpsw.dataproc.utils

object AWSLambdaEnvVars {
  val RecordSQSUrl = "RECORD_SQS_URL"
  val RecordSQSUrlDefaultValue = "https://sqs.us-east-1.amazonaws.com/970221509170/csv-data-processor"

  val FieldSeparator = "FIELD_SEPARATOR"
  val FieldSeparatorDefaultValue = ","

  val KinesisDataStream = "KINESIS_DATA_STREAM"
  val KinesisDataStreamDefaultValue = "bindb-data-stream"

  val DataStreamingMode = "DATA_STREAMING_MODE"
  val DataStreamingModeDefaultValue = "sqs"

  val SqsDataStreaming = "sqs"
  val kinesisDataStreaming = "kinesis"
}
