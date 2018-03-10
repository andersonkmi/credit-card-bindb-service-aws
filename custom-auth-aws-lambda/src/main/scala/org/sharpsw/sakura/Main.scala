package org.sharpsw.sakura

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.sharpsw.sakura.auth.AuthResponse

import scala.collection.JavaConverters._

object Main extends RequestHandler[java.util.Map[String, Object], AuthResponse]{
  override def handleRequest(event: java.util.Map[String, Object], context: Context): AuthResponse = {

    event.asScala.foreach(item => println(item._1 + " / " + item._2))
    val headers = event.get("headers")

    headers match {
      case Some(x: String) => println(x)
      case y: java.util.Map[_, _] => y.asScala.foreach(item => println(item._1 + "/" + item._2))
      case _ => println("something else")
    }
    new AuthResponse().setEffect("allow").setPrincipalId("kelly_ito").setResource(event.get("methodArn").toString)
  }
}
