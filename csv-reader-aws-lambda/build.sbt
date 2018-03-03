import Dependencies._

val appVersion = "1.0.0"

val appName = "csv-reader-aws-lambda"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.sharpsw",
      scalaVersion := "2.12.4",
      version      := appVersion,
      scalacOptions := Seq("-unchecked", "-deprecation", "-feature")
    )),
    name := appName,
    assemblyJarName in assembly := appName + "-" + appVersion + ".jar",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "1.3.0",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-sqs" % "1.11.209",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-core" % "1.11.213",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-cloudwatch" % "1.11.258",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3" % "1.11.280",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-kinesis" % "1.11.281",
    libraryDependencies += "org.json4s" %% "json4s-native" % "3.5.2",
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.5.2",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    libraryDependencies += "net.sourceforge.jtds" % "jtds" % "1.3.1",
    libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % "2.9.4"
  )




