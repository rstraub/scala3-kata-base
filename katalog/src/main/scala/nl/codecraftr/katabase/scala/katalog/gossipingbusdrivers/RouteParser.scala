package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

object RouteParser:
  def parse(unparsedRoutes: String): Seq[Route] =
    unparsedRoutes
      .split("\n")
      .toList
      .map(r => new Route(r.split(" ").map(_.toInt).toList))
