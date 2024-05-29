package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

import nl.codecraftr.katabase.scala.meta.Kata

@Kata("https://kata-log.rocks/gossiping-bus-drivers-kata")
object GossipingBusDrivers extends App:
  private val minutesInWorkday: Int = 60 * 8

  def simulate(input: String): String =
    val routes = RouteParser.parse(input)
    val drivers = BusDriver.createDrivers(routes)
    val simulated = GossipSimulator.simulate(drivers, minutesInWorkday)
    simulated.toString()

  println(simulate("""1
      |1""".stripMargin))
