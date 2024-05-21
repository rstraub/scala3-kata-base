package nl.codecraftr.scala.katabase.codewars.exesandohs

def xo(str: String): Boolean =
  val xsAndOhs = str.toLowerCase
    .filter(c => c == 'x' || c == 'o')
    .partition(_ == 'x')

  xsAndOhs._1.length == xsAndOhs._2.length
