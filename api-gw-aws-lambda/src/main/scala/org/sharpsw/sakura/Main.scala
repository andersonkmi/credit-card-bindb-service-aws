package org.sharpsw.sakura

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import scala.collection.JavaConverters._

class Main extends RequestHandler[java.util.Map[String, Object], BinDBResponse] {

  override def handleRequest(event: java.util.Map[String, Object], context: Context): BinDBResponse = {
    println("Starting authentication process")

    //val headers = event.asScala("headers")
    println(event.asScala)

    val response = new BinDBResponse()
    response.setBin("12345656")
    response.setCode("200")
    response
  }
}
