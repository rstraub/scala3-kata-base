package nl.codecraftr.scala.katabase.codewars.highestscoringword

object Scoring {
  private def scores =
    ('a' to 'z').zipWithIndex.map { case (c, i) => (c, i + 1) }.toMap

  def high(str: String): String =
    str.split(' ').map(w => score(w) -> w).maxBy(_._1)._2

  def score(word: String): Int = word.map(scores(_)).sum
}
