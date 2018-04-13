package org.sharpsw.sakura

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.sharpsw.sakura.service.DynamoDBService.findRecord

import scala.collection.JavaConverters._

class Main extends RequestHandler[java.util.Map[String, Object], BinDBResponse] {

  override def handleRequest(event: java.util.Map[String, Object], context: Context): BinDBResponse = {
    println("Starting authentication process")

    val binNumber = if (event.asScala.exists(_._1 == "bin")) event.asScala("bin") else ""
    println(binNumber)

    findRecord(binNumber.toString)
  }
}
