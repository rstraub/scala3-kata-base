package nl.codecraftr.katabase.scala.inspect

import nl.codecraftr.katabase.scala.meta.Kata
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.util.{ClasspathHelper, ConfigurationBuilder}

import scala.jdk.CollectionConverters.*

case class Metadata(
    kataName: String,
    packageName: String,
    url: String
)

private object Metadata:
  def apply(clazz: Class[?]) = new Metadata(
    kataName = clazz.getSimpleName.replace("$", ""),
    packageName = clazz.getPackageName,
    url = clazz.getAnnotation(classOf[Kata]).url()
  )

object AnnotationScanner:
  def scan(packageName: String): Seq[Metadata] =
    val reflections = new Reflections(
      new ConfigurationBuilder()
        .setUrls(ClasspathHelper.forPackage("nl.codecraftr.katabase.scala"))
        .setScanners(Scanners.TypesAnnotated)
    )

    reflections
      .getTypesAnnotatedWith(classOf[Kata])
      .asScala
      .toList
      .map(Metadata.apply)
      .distinctBy(_.kataName)
