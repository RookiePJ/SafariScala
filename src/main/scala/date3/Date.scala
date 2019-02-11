package date3

//class Date private (val day: Int, val month: Int, val year: Int = 2019) {
//  if (day < 1 || day > Date.daysInMonth(month, year) || month < 1 || month > 12)
//    throw new IllegalArgumentException("Bad Date")
//  override def toString:String =
//    s"Date, day = $day, month = $month, year = $year"
//}

case class Date (day: Int, month: Int, year: Int = 2019) {
  if (day < 1 || day > Date.daysInMonth(month, year) || month < 1 || month > 12)
    throw new IllegalArgumentException("Bad Date")
}

object Date {
//  def apply(day: Int, month: Int): Date = new Date(day, month)
//  def apply(day: Int, month: Int, year: Int): Date = new Date(day, month, year)

  def dayOfWeek(day: Int, month: Int, year: Int = 2019): Int = {
    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400) % 7
  }

  def daysInMonth(m: Int, y: Int): Int = m match {
    case 9 | 4 | 6 | 11 => 30
    case 2 => if (isLeapYear(y)) 29 else 28
    case 1 | 3 | 5 | 7 | 8 | 10 | 12 => 31
  }

  def isLeapYear(y: Int): Boolean =
    y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)

  def dayName(day: Int): String = day match {
    case 0 => "Saturday"
    case 1 => "Sunday"
    case 2 => "Monday"
    case 3 => "Tuesday"
    case 4 => "Wednesay"
    case 5 => "Thursday"
    case 6 => "Friday"
  }
}

object TryDates {
  def main(args: Array[String]): Unit = {
    val d = Date(1, 1, 2000)

    val d2 = Date(1, 1, 2000)
    val d3 = Date(1, 2, 2000)

    println(s"d == d2? ${d == d2}")
    println(s"d3 == d2? ${d3 == d2}")
//    val d2 = new Date
    println(s"the date d is $d")

    //    val d2 = new Date(1, 1, 2000)
    //    new Date(29, 2, 1900)

    Date(1, 2, 2000) match {
      case Date(1, 1, 2000) => println("Welcome to the (not) new millenium")
      case Date(d, m, y) => println(s"Day $d, month $m, year $d, isn't special")
    }
  }
}