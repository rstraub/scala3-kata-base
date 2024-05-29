package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

import nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers.BusDriver.createDrivers
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class GossipSimulatorTest
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks:
  "simulate" should "run drivers through their routes for the specified number of minutes" in:
    val drivers = createDrivers(
      List(
        Route(1, 2, 4),
        Route(3, 2, 5)
      )
    )

    val inputs = Table(
      ("input", "expected"),
      (0, Seq(1, 3)),
      (1, Seq(2, 2)),
      (2, Seq(4, 5))
    )

    forAll(inputs) { (input, expected) =>
      GossipSimulator
        .simulate(drivers, input)
        .map(_.currentStop) shouldBe expected
    }
