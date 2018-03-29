package ru.yudnikov

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import net.superkassa.actors.DatabaseReader
import ru.yudnikov.database.postgres.{PostgresSession, PostgresSettings}

object Example extends App {

  val config = ConfigFactory.load("database.conf")
  val pg = PostgresSession(PostgresSettings(config))
  val actorSystem = ActorSystem("superkassa", config)
  actorSystem.actorOf(Props(classOf[DatabaseReader], pg))

}
