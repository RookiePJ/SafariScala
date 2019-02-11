package exceptions

import scala.io.Source
import scala.util.{Success, Try, Failure}

object Ex3 {
  def main(args: Array[String]): Unit = {
    Try {
      Source.fromFile("dat.txt").getLines()
    } match {
      case Success(v) => for (l <- v) println(l)
      case Failure(f) => println(s"broke, message ${f.getMessage}")
    }

//    for (l <- li) println(s"> ${l}")
  }
}
