package org.sharpsw.dataproc

import scala.collection.JavaConverters._
import com.amazonaws.services.lambda.runtime.events.S3Event
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord
import org.sharpsw.dataproc.utils.S3FileReader.readFile

class Main {

  def processFileContents(event: S3Event): String = {
    event.getRecords.asScala.foreach(processFile)
    "OK"
  }

  private def processFile(event: S3EventNotificationRecord): Unit = {
    val bucket = event.getS3.getBucket.getName
    val key = event.getS3.getObject.getKey
    readFile(bucket, key)
  }
}
