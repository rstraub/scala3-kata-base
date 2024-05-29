package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

case class Route(stops: List[Int])

object Route:
  def apply(stops: Int*) = new Route(stops.toList)
