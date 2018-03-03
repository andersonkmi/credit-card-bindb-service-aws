package org.sharpsw.dataproc

import com.amazonaws.services.lambda.runtime.Context

import scala.collection.JavaConverters._
import com.amazonaws.services.lambda.runtime.events.S3Event
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord
import org.sharpsw.dataproc.utils.S3FileReader.readFile
import org.slf4j.LoggerFactory

class Main {
  private val logger = LoggerFactory.getLogger(getClass)

  def processFileContents(event: S3Event, context: Context): String = {
    event.getRecords.asScala.foreach(processFile)
    logger.info(s"Memory limit (MB): ${context.getMemoryLimitInMB}")
    logger.info(s"Remaining time (ms): ${context.getRemainingTimeInMillis}")
    "OK"
  }

  private def processFile(event: S3EventNotificationRecord): Unit = {
    val bucket = event.getS3.getBucket.getName
    val key = event.getS3.getObject.getKey
    readFile(bucket, key)
  }
}
