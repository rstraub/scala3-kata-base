package nl.codecraftr.katabase.scala.codewars.exesandohs

import nl.codecraftr.katabase.scala.meta.Kata

@Kata("https://www.codewars.com/kata/55908aad6620c066bc00002a/train/scala")
object ExesAndOhs:
  def xo(str: String): Boolean =
    val xsAndOhs = str.toLowerCase
      .filter(c => c == 'x' || c == 'o')
      .partition(_ == 'x')

    xsAndOhs._1.length == xsAndOhs._2.length
