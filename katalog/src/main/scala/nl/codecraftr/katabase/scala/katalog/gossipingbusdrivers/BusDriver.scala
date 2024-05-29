package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

case class BusDriver(gossips: List[String], route: Route)

object BusDriver:
  def createDrivers(routes: Seq[Route]): Seq[BusDriver] =
    routes.zipWithIndex.map { (r, i) =>
      BusDriver(List(s"Gossip ${i + 1}"), r)
    }
