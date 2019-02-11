package exceptions

import java.io.FileNotFoundException
import java.sql.SQLException
import java.util.concurrent.ThreadLocalRandom

object Ex1 {

  def dodgy: Unit = ThreadLocalRandom.current.nextInt(0, 7) match {
    case 0 | 1 | 2 => ()
    case 3 => throw new SQLException
    case 4 => throw new FileNotFoundException("Banana.txt not found!!!")
    case _ => throw new RuntimeException
  }
  def main(args: Array[String]): Unit = {
    try {
      dodgy
    } catch {
      // Scala code should "never" use "instanceOf" nor casts...
      case x: FileNotFoundException => println("FileNotFound: " + x.getMessage)
      case x: SQLException => println("got a problem")
      case x: RuntimeException => println("got a RuntimeException")
      case _ : Throwable => println("Bad!!")
    }
  }

}
