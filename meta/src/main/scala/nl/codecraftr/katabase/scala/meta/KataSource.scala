package nl.codecraftr.katabase.scala.meta

import java.net.URI

object KataSource {
  def source(kata: Kata): String = new URI(kata.url).toURL.getHost
}
