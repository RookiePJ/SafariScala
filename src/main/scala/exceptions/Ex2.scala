package exceptions

import java.util.concurrent.ThreadLocalRandom

import scala.util.{Failure, Success, Try}

object Ex2 {
  def dodgy:Try[String] = ThreadLocalRandom.current.nextInt(0, 2) match {
    case 0 => Success("Yay, it worked")
    case _ => Failure(new RuntimeException("it broke"))
  }


  def main(args: Array[String]): Unit = {
//    val t/*: Try[String]*/ = dodgy

//    dodgy match {
//      case v:Success[String] =>
//        println(s"That worked, value is ${v.value}")
//      case f:Failure[String] =>
//        println(s"That broke, message is ${f.exception.getMessage}")
//    }

    dodgy match {
      case Success(s) =>
        println(s"That worked, value is ${s}")
      case Failure(e) =>
        println(s"That broke, message is ${e.getMessage}")
    }
  }
}
