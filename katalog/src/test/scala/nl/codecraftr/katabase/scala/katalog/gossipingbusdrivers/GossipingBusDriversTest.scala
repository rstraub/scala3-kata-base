package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.io.Source

class GossipingBusDriversTest extends AnyFlatSpec with Matchers:
  "gossip" should "return amount of minutes given all gossips exchanged during workday" ignore:
    val input =
      Source.fromResource("all-exchanged.txt").getLines().mkString("\n")

    GossipingBusDrivers.simulate(input) shouldBe "5"

  it should "return 'never' given gossips are not all exchanged during workday" ignore:
    val input =
      Source.fromResource("not-exchanged.txt").getLines().mkString("\n")

    GossipingBusDrivers.simulate(input) shouldBe "never"
