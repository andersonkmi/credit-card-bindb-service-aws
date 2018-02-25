package org.sharpsw.dataproc.aws

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.sharpsw.dataproc.data.BinRecord

object DynamoDB {
  private val dynamoService = AmazonDynamoDBClientBuilder.standard.build

  def putRecord(record: BinRecord): Boolean = {
    true
  }
}
