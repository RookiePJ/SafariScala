package date

object Date {
  // overloads per "normal" same function name, different type-lists for args.
  def dayOfWeek(day: Int, month: Int, year: Int = 2019): Int = {
    //    val m = if (month < 3) month + 12 else month
    //    val y = if (month < 3) year - 1 else year

    //    val t = if (month < 3) (month + 12, year - 1) else (month, year)
    //    println(s"modified month is ${t._1}")
    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400) % 7
  }

  //  def dayName(day: Int): String =
  //    if (day == 0) "Saturday"
  //    else if (day == 1) "Sunday"
  //    else "Not sure!"

  def dayName(day: Int): String = day match {
    case 0 => "Saturday"
    case 1 => "Sunday"
    case 2 => "Monday"
    case 3 => "Tuesday"
    case 4 => "Wednesay"
    case 5 => "Thursday"
    case 6 => "Friday"
  }

  object DayName extends Enumeration {
    type TYPE = Value
    val SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY = Value
  }

  def dayID(day: Int): DayName.TYPE = DayName(day)

  def main(args: Array[String]): Unit = {
    println(s"day of week of 1/1/2000 ${dayName(dayOfWeek(1, 1, 2000))}")
    println(s"day of week of 1/1/1900 ${dayName(dayOfWeek(1, 1, 1900))}")
    println(s"day of week of 1/3/2000 ${dayName(dayOfWeek(month = 3, day = 1, year = 2000))}")
    println(s"day of week of 1/3/2019 ${dayName(dayOfWeek(month = 3, day = 1))}")

    println(s"day of week of 1/1/2000 ${DayName(dayOfWeek(1, 1, 2000))}")
    println(s"day of week of 1/1/1900 ${DayName(dayOfWeek(1, 1, 1900))}")

    println(s"type of DayName.SATURDAY is ${DayName.SATURDAY.getClass.getName}")

    try {
      println(s"bad day of week ${dayName(-1)}")
    } catch {
      case x => println(s"That broke ${x.getMessage}")
    }
    println("Aaaand we're back...")
  }
}
