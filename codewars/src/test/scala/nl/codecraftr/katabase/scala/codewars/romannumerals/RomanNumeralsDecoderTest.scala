package nl.codecraftr.katabase.scala.codewars.romannumerals

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RomanNumeralsDecoderTest extends AnyFlatSpec with Matchers {
  "decode" should "pass basic tests" in {
    val testCases = List( // roman, expected
      ("I", 1),
      ("III", 3),
      ("IV", 4),
      ("XXI", 21),
      ("MDCLXVI", 1666),
      ("MCMXC", 1990),
      ("MMVIII", 2008)
    )

    testCases.foreach { case (roman, expected) =>
      assertResult(expected, s"\nInput\n  roman = $roman") {
        RomanNumeralsDecoder.decode(roman)
      }
    }
  }
}
