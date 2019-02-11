package date2

class Date private (d: Int, m: Int, y: Int = 2019) {
  println("This is a constructor invocation for Date")

  def this() {
    this(1, 1, 2000)
    println("auxiliary constructor...")
  }

  override def toString:String = s"Date, day = $day, month = $month, year = $year"

  if (d < 1 || d > Date.daysInMonth(m, y) || m < 1 || m > 12)
    throw new IllegalArgumentException("Bad Date")
  //  var day: Int = _
  //  var month: Int = _
  //  var year: Int = _
    val day: Int = d
    val month: Int = m
    val year: Int = y
}

object Date {

  def apply(day: Int, month: Int): Date = new Date(day, month)
  def apply(day: Int, month: Int, year: Int): Date = new Date(day, month, year)

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
    val d2 = new Date
    println(s"the date d is $d")

//    val d2 = new Date(1, 1, 2000)
    //    new Date(29, 2, 1900)
  }
}