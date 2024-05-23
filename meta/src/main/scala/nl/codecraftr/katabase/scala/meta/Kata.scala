package nl.codecraftr.katabase.scala.meta

import java.net.URI
import scala.annotation.StaticAnnotation

/** Idea!
  *
  * Use annotations to tie the url to a solution of a kata. This can feed into
  * creating an overview page of all kata's I've done. It can also feed into
  * doing some analytics (e.g. no of kata's).
  *
  * Both could be automated by the CI/CD pipeline and thus kept in sync.
  */
case class Kata(url: String) extends StaticAnnotation {
  def source(): String = new URI(url).toURL.getHost
}
