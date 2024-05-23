package nl.codecraftr.katabase.scala.exercism.flattenarray

import nl.codecraftr.katabase.scala.meta.Kata

@Kata("https://exercism.org/tracks/scala/exercises/flatten-array")
object FlattenArray:
  @SuppressWarnings(
    Array(
      "scalafix:DisableSyntax.null"
    )
  )
  def flatten(values: List[Any]): List[Any] =
    values.flatMap {
      case e: List[?]     => flatten(e)
      case e if e == null => List.empty
      case e              => List(e)
    }
