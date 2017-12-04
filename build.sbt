name := "FinatraSimpleServer"

version := "0.1"

scalaVersion := "2.12.4"
lazy val versions = new {
  val finatra = "17.11.0"
  val logback = "1.1.3"
}

libraryDependencies += "com.twitter" %% "finatra-http" %  versions.finatra
//libraryDependencies += "ch.qos.logback" % "logback-classic" % versions.logback