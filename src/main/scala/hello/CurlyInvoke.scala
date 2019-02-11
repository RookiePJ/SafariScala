package hello

object CurlyInvoke {
  def doStuff(s: => String): Unit = {
    println("about to print my argument...")
    if (math.random() > 0.5) {
      println(s)
    }
  }

  def main(args: Array[String]): Unit = {
//    doStuff("Hello")
    doStuff {
      println("Really?")
      "Hello"
    }
  }
}
