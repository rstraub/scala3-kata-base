package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

import nl.codecraftr.katabase.scala.meta.Kata

@Kata("https://kata-log.rocks/gossiping-bus-drivers-kata")
object GossipingBusDrivers extends App:
  def simulate(input: String): String =
      val routes = RouteParser.parse(input)
      val drivers = BusDriver.createDrivers(routes)
      drivers.toString()

  println(simulate("""1
      |1""".stripMargin))
