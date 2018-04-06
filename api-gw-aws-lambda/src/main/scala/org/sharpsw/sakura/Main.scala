package org.sharpsw.sakura

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.json4s.{DefaultFormats, Formats}

import scala.collection.JavaConverters._
import org.json4s.jackson.Serialization.write

class Main extends RequestHandler[java.util.Map[String, Object], String] {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  override def handleRequest(event: java.util.Map[String, Object], context: Context): String = {
    println("Starting authentication process")

    //val headers = event.asScala("headers")
    println(event.asScala)

    val response = BinDBResponse("123", "200")
    write(response)
  }
}
