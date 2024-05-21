package nl.codecraftr.scala.katabase.codewars.exesandohs

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class ExesAndOhsSpec
    extends AnyWordSpec
    with Matchers
    with TableDrivenPropertyChecks:
  private val matchedCases = Table(
    "input",
    "xo",
    "xoxo",
    "xO",
    "xoM"
  )

  private val unmatchedCases =
    Table("input", "xox", "x", "zzoo")

  "xo" should:
    forAll(matchedCases) { str =>
      s"return true given matched x's and o's '$str'" in:
        xo(str) shouldBe true
    }

    forAll(unmatchedCases) { str =>
      s"return false given unmatched x's and o's '$str'" in:
        xo(str) shouldBe false
    }
