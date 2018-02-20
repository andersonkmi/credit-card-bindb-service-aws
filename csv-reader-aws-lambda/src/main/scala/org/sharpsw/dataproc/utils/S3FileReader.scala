package org.sharpsw.dataproc.utils

import java.io.{BufferedReader, InputStreamReader}

import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.GetObjectRequest
import org.json4s.{DefaultFormats, Formats}
import org.json4s.jackson.Serialization.write
import org.sharpsw.dataproc.data.BinRecord
import org.sharpsw.dataproc.utils.AWSLambdaEnvVars.{FieldSeparator, FieldSeparatorDefaultValue}
import org.sharpsw.dataproc.utils.Queue.enqueue

import scala.util.Properties

object S3FileReader {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  private val s3Service = AmazonS3ClientBuilder.standard.build

  def readFile(bucket: String, key: String): Unit = {
    // Opens the file
    val s3object = s3Service.getObject(new GetObjectRequest(bucket, key))
    //println(s3object.getObjectMetadata.getContentType)
    //println(s3object.getObjectMetadata.getContentLength)

    val reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent))
    var line:String = null

    while ({line = reader.readLine; line != null}) {
      val tokens = line.split(Properties.envOrElse(FieldSeparator, FieldSeparatorDefaultValue))
      val record = BinRecord(tokens(0), tokens(1), tokens(2), tokens(3), tokens(4), tokens(5), tokens(6))
      val json = write(record)
      enqueue(json)
    }
    reader.close

  }
}
