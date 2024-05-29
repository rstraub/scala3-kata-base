package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

import scala.annotation.tailrec

object GossipSimulator:
  @tailrec
  def simulate(drivers: Seq[BusDriver], remainingMinutes: Int): Seq[BusDriver] =
    if remainingMinutes == 0 then drivers
    else simulate(drivers.map(_.drive), remainingMinutes - 1)
