package nl.codecraftr.katabase.scala.inspect

import nl.codecraftr.katabase.scala.meta.Kata
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.util.{ClasspathHelper, ConfigurationBuilder}

import scala.jdk.CollectionConverters.*

// https://github.com/rstraub/scala3-kata-base/blob/main/codewars/src/main/scala/nl/codecraftr/katabase/scala/codewars/highestscoringword/HighestScoringWord.scala
private case class Metadata(
    kataName: String,
    packageName: String,
    url: String
)

object Metadata:
  def apply(clazz: Class[?]) = new Metadata(
    kataName = clazz.getSimpleName.replace("$", ""),
    packageName = clazz.getPackageName,
    url = clazz.getAnnotation(classOf[Kata]).url()
  )

object AnnotationScanner extends App:
  private val reflections = new Reflections(
    new ConfigurationBuilder()
      .setUrls(ClasspathHelper.forPackage("nl.codecraftr.katabase.scala"))
      .setScanners(Scanners.TypesAnnotated)
  )

  private val annotatedClasses: Seq[Metadata] =
    reflections
      .getTypesAnnotatedWith(classOf[Kata])
      .asScala
      .toList
      .map(Metadata.apply)
      .distinctBy(_.kataName)

  annotatedClasses.foreach(println(_))
