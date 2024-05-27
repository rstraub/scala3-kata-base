package nl.codecraftr.katabase.scala.inspect

object MarkdownBuilder {
  def build(metadata: Seq[Metadata]): String =
    val metaLines =
      metadata.map(m => s"- [${m.kataName}](${m.url})").mkString("\n")

    s"""# Katabase
      |
      |$metaLines
      |""".stripMargin
}
