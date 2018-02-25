package org.sharpsw.dataproc.utils

import java.io.{BufferedReader, InputStreamReader}

import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.GetObjectRequest
import org.sharpsw.dataproc.data.BinRecord
import org.sharpsw.dataproc.utils.AWSLambdaEnvVars._
import org.sharpsw.dataproc.utils.Kinesis.putRecord
import org.sharpsw.dataproc.utils.Queue.enqueue

import scala.util.Properties

object S3FileReader {
  private val s3Service = AmazonS3ClientBuilder.standard.build

  def readFile(bucket: String, key: String): Unit = {
    val s3object = s3Service.getObject(new GetObjectRequest(bucket, key))
    val reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent))
    var line:String = null

    while ({line = reader.readLine; line != null}) {
      val tokens = line.split(Properties.envOrElse(FieldSeparator, FieldSeparatorDefaultValue))
      val record = BinRecord(tokens(0), tokens(1), tokens(2), tokens(3), tokens(4), tokens(5), tokens(7))
      if(Properties.envOrElse(DataStreamingMode, DataStreamingModeDefaultValue).equalsIgnoreCase(BatchDataStreaming)) enqueue(record) else putRecord(record, Properties.envOrElse(KinesisDataStream, KinesisDataStreamDefaultValue))
    }
    reader.close()
  }
}
