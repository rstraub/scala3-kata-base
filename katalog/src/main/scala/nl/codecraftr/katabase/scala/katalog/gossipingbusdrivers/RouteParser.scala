package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

object RouteParser:
  def parse(rawRoutes: String): Seq[Seq[Int]] =
    rawRoutes
      .split("\n")
      .toList
      .map(_.split(" ").map(_.toInt).toList)
