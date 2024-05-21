package nl.codecraftr.scala.katabase.codewars.exesandohs

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class ExesAndOhsSpec
    extends AnyWordSpec
    with Matchers
    with TableDrivenPropertyChecks:
  private val matchedCases = Table(
    ("in"),
    ("xo"),
    ("xoxo")
  )

  private val unmatchedCases =
    Table("in", "xox", "x")

  "xo" should:
    forAll(matchedCases) { str =>
      s"return true given equal x's and o's $str" in:
        xo(str) shouldBe true
    }

    forAll(unmatchedCases) { str =>
      s"return false given unequal x's and o's $str" in:
        xo(str) shouldBe false
    }
