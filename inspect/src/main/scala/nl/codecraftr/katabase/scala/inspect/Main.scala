package nl.codecraftr.katabase.scala.inspect

import nl.codecraftr.katabase.scala.exercism.flattenarray.FlattenArray

@main def runInspection(): Unit =
  AnnotationInspector.getAnnotations[FlattenArray.type].foreach(println)
