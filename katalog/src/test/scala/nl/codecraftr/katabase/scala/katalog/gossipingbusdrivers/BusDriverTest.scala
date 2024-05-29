package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BusDriverTest extends AnyFlatSpec with Matchers:
  "create" should "return bus drivers given routes" in:
    BusDriver.createDrivers(
      Seq(
        Route(1, 2, 3),
        Route(4, 5, 6)
      )
    ) shouldBe Seq(
      BusDriver(List("Gossip 1"), Route(1, 2, 3)),
      BusDriver(List("Gossip 2"), Route(4, 5, 6))
    )
