package hello

object Hello {
  def main(args: Array[String]): Unit = {
    //    val x: Int = 99
    val x = 99
    //    x = 2
    println("Hello Scala World!")
    val countOfOranges = 9
    val updatedCountOfOranges = countOfOranges + 1

    var y = 3
    y = y + 2

    println(s"the value of y + x is ${y + x}")
    println(s"the value of y is $y")

    println(s"the argument count is ${args.length}")
    println(s"the first argument is ${args(0)}")
    var index = 0
    while (index < args.length) {
      println(s"arg $index is ${args.apply(index)}")
      index += 1
    }
    println("--------------------")

    val odd = if (x >= 0) {
      "X is positive"
    } else {
      99
    }
    println(s"is odd == Unit?? ${odd == ()} value of odd is $odd")

    val interesting /*: Array[String]*/ = for {
      w <- args
      if w.length == 3
//      wUpper = w.toUpperCase
//    } yield wUpper
    } yield w.toUpperCase

    println("-----------------")
    for (v <- interesting) println(v)
  }
}
