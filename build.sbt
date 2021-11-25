name := "scala-quill-project"

version := "0.1"

scalaVersion := "2.12.10"


libraryDependencies ++= Seq(
  "com.typesafe.akka"          %% "akka-http"            % "10.1.10",
  "com.typesafe.akka"          %% "akka-stream"          % "2.5.23",
  "com.typesafe.akka"          %% "akka-http-spray-json" % "10.1.10",
  "org.postgresql"             % "postgresql"            % "42.2.5",
  "org.slf4j"                  % "slf4j-nop"             % "1.7.26",
  "io.getquill"                %% "quill-async-postgres" % "3.7.0",
  "com.typesafe.scala-logging" %% "scala-logging"        % "3.9.2",
  "com.typesafe.akka"          %% "akka-stream-kafka"    % "0.20",
  "nl.grons"                   %% "metrics4-scala"       % "4.1.19",
)