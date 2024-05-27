package nl.codecraftr.katabase.scala.meta

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

import java.lang.annotation.Annotation

class KataTest extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks:
  "source" should "extract the source of the kata given a known source" in:
    val cases = Table(
      ("input", "expected"),
      (
        "https://www.codewars.com/kata/5502c9e7b3216ec63c0001aa/scala",
        "www.codewars.com"
      ),
      (
        "https://exercism.org/tracks/scala/exercises/flatten-array",
        "exercism.org"
      ),
      ("https://kata-log.rocks/bowling-game-kata", "kata-log.rocks"),
      ("https://codingdojo.org/kata/Mastermind/", "codingdojo.org")
    )

    forAll(cases) { (input, expected) =>
      val k = new Kata:
        override def url(): String = input

        override def annotationType(): Class[? <: Annotation] = ???

      KataSource.source(k) shouldBe expected
    }
