package nl.codecraftr.katabase.scala.codewars.categorizenewmember

import nl.codecraftr.katabase.scala.meta.Kata

@Kata("https://www.codewars.com/kata/5502c9e7b3216ec63c0001aa/scala")
object CategorizeMember:
  def openOrSenior(data: List[(Int, Int)]): List[String] = data.map {
    case (age, handicap) if age >= 55 && handicap > 7 => "Senior"
    case _                                            => "Open"
  }
