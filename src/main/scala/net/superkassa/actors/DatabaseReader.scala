package net.superkassa.actors

import akka.cluster.Cluster
import akka.cluster.ddata.DistributedData
import akka.persistence._
import akka.actor._
import net.superkassa.actors.DatabaseReader.Refresh

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import ru.yudnikov.database.postgres.PostgresSession

import scala.concurrent.Await

case class DatabaseReader(postgresSession: PostgresSession) extends PersistentActor {
  val cluster = Cluster(context.system)
  val replicator = DistributedData(context.system).replicator
  context.system.scheduler.schedule(0.second, 3.second, self, Refresh)
  var state: Long = _
  var portsToCities: Map[String, String] = Map()
  override def recovery: Recovery = {
    Recovery(toSequenceNr = 3L)
    //Recovery.none
    //super.recovery
  }

  override def receiveRecover: Receive = {
    case SnapshotOffer(_, history) =>
      history
    case x =>
      x
      x
  }

  def updateState(): Unit = state += 1

  override def receiveCommand: Receive = {
    case Refresh =>
      println(s"state: $state")
      persist() {updateState}
      val number = lastSequenceNr
      println(s"refresh $number")
    case x =>
      x
  }

  override def persistenceId: String = getClass.getSimpleName

}

object DatabaseReader {

  object refresh

}
