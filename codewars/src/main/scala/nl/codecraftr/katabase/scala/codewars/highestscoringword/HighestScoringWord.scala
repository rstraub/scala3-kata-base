package nl.codecraftr.katabase.scala.codewars.highestscoringword

import nl.codecraftr.katabase.scala.meta.Kata

@Kata("https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/scala")
object HighestScoringWord {
  private def scores =
    ('a' to 'z').zipWithIndex.map { case (c, i) => (c, i + 1) }.toMap

  def high(str: String): String =
    str.split(' ').map(w => score(w) -> w).maxBy(_._1)._2

  def score(word: String): Int = word.map(scores(_)).sum
}
