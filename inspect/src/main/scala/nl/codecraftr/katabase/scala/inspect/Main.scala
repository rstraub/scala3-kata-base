package nl.codecraftr.katabase.scala.inspect

import java.nio.file.{Files, Paths}

@main def createLivingDocs(): Unit = {
  val metadata = AnnotationScanner
    .scan("nl.codecraftr.katabase.scala")

  val md = MarkdownBuilder.build(metadata)

  val path = storeFile(md)
  println(s"Wrote to file $path")
}

private def storeFile(markdown: String) =
  val filepath = Paths.get("target/katabase.md")
  Files.write(filepath, markdown.getBytes)
