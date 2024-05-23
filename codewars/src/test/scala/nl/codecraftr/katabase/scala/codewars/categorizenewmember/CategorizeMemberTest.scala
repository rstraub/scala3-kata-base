package nl.codecraftr.katabase.scala.codewars.categorizenewmember

import nl.codecraftr.katabase.scala.codewars.categorizenewmember.CategorizeMember.openOrSenior
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class CategorizeMemberTest
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks:
  private val cases = Table(
    ("input", "expected"),
    (
      List((45, 12), (55, 21), (19, -2), (104, 20)),
      List("Open", "Senior", "Open", "Senior")
    ),
    (
      List((3, 12), (55, 1), (91, -2), (54, 23)),
      List("Open", "Open", "Open", "Open")
    ),
    (
      List((59, 12), (55, -1), (12, -2), (12, 12)),
      List("Senior", "Open", "Open", "Open")
    ),
    (
      List((74, 10), (55, 6), (12, -2), (68, 7)),
      List("Senior", "Open", "Open", "Open")
    ),
    (
      List((16, 23), (56, 2), (56, 8), (54, 6)),
      List("Open", "Open", "Senior", "Open")
    )
  )

  "openOrSenior" should "return open or senior" in:
    forAll(cases) { (input, expected) =>
      openOrSenior(input) shouldBe expected
    }
