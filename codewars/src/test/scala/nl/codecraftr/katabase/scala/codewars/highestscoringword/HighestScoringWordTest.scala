package nl.codecraftr.katabase.scala.codewars.highestscoringword

import HighestScoringWord.{high, score}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class HighestScoringWordTest
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks {
  """high("man i need a taxi up to ubud")""" should """return "taxi" """ in {
    high("man i need a taxi up to ubud") should be("taxi")
  }
  """high("what time are we climbing up to the volcano")""" should """return "volcano" """ in {
    high("what time are we climbing up to the volcano") should be("volcano")
  }
  """high("take me to semynak")""" should """return "semynak" """ in {
    high("take me to semynak") should be("semynak")
  }
  """high("for equals return earliestg")""" should """return "return" """ in {
    high("for equals return earliestg") should be("return")
  }
  """high("find or finda")""" should """return "finda" """ in {
    high("find or finda") should be("finda")
  }
  """high("aa b")""" should """return "aa" """ in {
    high("aa b") should be("aa")
  }
  """high("b aa")""" should """return "b" """ in {
    high("b aa") should be("b")
  }
  """high("bb d")""" should """return "bb" """ in {
    high("bb d") should be("bb")
  }
  """high("d bb")""" should """return "d" """ in {
    high("d bb") should be("d")
  }
  """high("aaa b")""" should """return "aaa" """ in {
    high("aaa b") should be("aaa")
  }

  private val cases = Table(
    ("input", "expected"),
    ("abab", 1 + 2 + 1 + 2),
    ("abad", 1 + 2 + 1 + 4)
  )

  "score" should "return score of a word" in {
    forAll(cases) { (input, expected) =>
      score(input) shouldBe expected
    }
  }
}
