package nl.codecraftr.katabase.scala.codewars.categorizenewmember

def openOrSenior(data: List[(Int, Int)]): List[String] = data.map {
  case (age, handicap) if age >= 55 && handicap > 7 => "Senior"
  case _                                            => "Open"
}
