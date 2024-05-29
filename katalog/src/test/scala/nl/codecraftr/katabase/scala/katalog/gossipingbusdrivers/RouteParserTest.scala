package nl.codecraftr.katabase.scala.katalog.gossipingbusdrivers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RouteParserTest extends AnyFlatSpec with Matchers:
  "parse" should "return routes given a valid input" in:
    val input =
      """1 2 3
        |4 5 6""".stripMargin

    RouteParser.parse(input) shouldBe List(List(1, 2, 3), List(4, 5, 6))
