name := "superkassa"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.9",
  "com.typesafe" % "config" % "1.2.1",
  "org.scalatest" % "scalatest_2.11" % "2.1.3" % Test,
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "com.typesafe.akka" %% "akka-actor" % "2.5.4",
  "com.typesafe.akka" %% "akka-cluster" % "2.5.4",
  "com.typesafe.akka" %% "akka-distributed-data" % "2.5.4",
  "com.typesafe.akka" %% "akka-persistence" % "2.5.4",
  "org.iq80.leveldb" % "leveldb" % "0.7",
  "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8"
)