package nl.codecraftr.scala.katabase.codewars

import nl.codecraftr.scala.katabase.codewars.Main.hello
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CanarySpec extends AnyFlatSpec with Matchers:
  "Canary" should "be alive" in:
    hello("dev") shouldBe "Hello, creator!"

  it should "be dead" in:
    hello("world") shouldBe "Hello, world!"
