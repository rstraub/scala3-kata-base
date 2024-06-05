package nl.codecraftr.katabase.scala.codewars.romannumerals

import nl.codecraftr.katabase.scala.meta.Kata

import scala.collection.immutable.ListMap

@Kata(url =
  "https://www.codewars.com/kata/51b6249c4612257ac0000005/train/scala"
)
object RomanNumeralsDecoder {
  private val mapping = ListMap(
    "CM" -> 900,
    "M" -> 1000,
    "D" -> 500,
    "XC" -> 90,
    "C" -> 100,
    "L" -> 50,
    "XL" -> 40,
    "X" -> 10,
    "IV" -> 4,
    "V" -> 5,
    "I" -> 1
  )

  def decode(roman: String): Int =
    decode(roman, 0)

  private def decode(remainder: String, totalValue: Int): Int =
    if remainder.isBlank then totalValue
    else
      mapping
        .find { case (symbol, value) => remainder.contains(symbol) }
        .map { case (symbol, value) =>
          decode(remainder.replaceFirst(symbol, ""), totalValue + value)
        }
        .getOrElse(totalValue)
}
