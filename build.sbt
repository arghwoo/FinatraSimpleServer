name := "FinatraSimpleServer"

version := "0.1"

scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.2")

lazy val versions = new {
  val finatra = "17.11.0"
  val logback = "1.1.3"
  val casbah = "3.1.1"
}

libraryDependencies += "com.twitter" %% "finatra-http" %  versions.finatra
libraryDependencies += "ch.qos.logback" % "logback-classic" % versions.logback
libraryDependencies += "org.mongodb" %% "casbah" % versions.casbah