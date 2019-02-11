package recursion

import scala.annotation.tailrec

object UseList {

//  @tailrec
  def change[T, U](l: List[T], op: T => U): List[U] = l match {
    case Nil => Nil
    case h :: t => op(h) :: change(t, op)
  }

  @tailrec
  def showListContents[T](l: List[T]): Unit = l match {
    case Nil => ()
    case h :: t => println(h) ; showListContents(t)/*; println("Finished")*/
//    case List(one, two)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Fred", "Jim", "Sheila")
//    for(n <- names) println(n)
    showListContents(names)

    showListContents(change(names, (s:String) => s.toUpperCase))

    names.map(s => s.toLowerCase()).foreach(s => println(s"> ${s}"))
  }
}
