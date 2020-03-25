package models

import slick.jdbc.JdbcBackend.Database
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext._
import scala.concurrent.Future


case class Thing(id: Long, oneThing: String, anotherThing: String)



class ThingTable(val db: Database, val profile: JdbcProfile)  {

  import profile.api._
  class ThingTableDef(tag: Tag) extends Table[Thing](tag, "Thing") {

    lazy val id = column[Long]("id")
    lazy val oneThing = column[String]("one_thing")
    lazy val anotherThing = column[String]("another_thing")

    def * =
      (
        id,
        oneThing,
        anotherThing
      ) <> (Thing.tupled, Thing.unapply)
  }

  object Queries {

    def getThingByIds(ids: Seq[Long]): Future[Seq[Thing]] = {

      if (ids.nonEmpty) {
        val thingIds = ids.map(_.toString).mkString(",")
        db.run {

          sql"""
          SELECT oneThing, otherThing FROM "Thing" WHERE id  IN (#$thingIds);
          """
            .as[(Long,
              String,
              String,
              )]
            .map(_.map {
              case (id: Long,
              oneThing: String,
              anotherThing: String) =>
                Thing(id, oneThing, anotherThing)

            }.toSeq)(global)
        }
      }
      else {
        Future.successful(Seq.empty[Thing])
      }
    }
  }

}