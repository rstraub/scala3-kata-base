package nl.codecraftr.katabase.scala.exercism.flattenarray

object FlattenArray:
  def flatten(values: List[Any]): List[Any] =
    values.flatMap {
      case e: List[?]     => flatten(e)
      case e if e == null => List.empty
      case e              => List(e)
    }
