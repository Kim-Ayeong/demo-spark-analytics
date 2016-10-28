/**
  * Created by skiper on 2016. 10. 25..
  */
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

import scala.util.{Failure, Success, Try}
object HelloScala {
  def main(args: Array[String]) : Unit = {
    println("Helo Scala")
    val str = getTimestamp("2014-10-20 02:24:55").get
    println(str)

    val s = "\"test\""
    println(s)
    val s1 = s.replace("\"", "")
    println(s1)



    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    println(format.format(Calendar.getInstance().getTime()))
    val ts = new Timestamp(Calendar.getInstance().getTime().getTime)
    print(ts)
  }

  def getTimestamp(s: String) : Option[Timestamp] = s match {
    case "" => None
    case _ => {
      val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")//2
      println(new Timestamp(format.parse(s).getTime))

      Try(new Timestamp(format.parse(s).getTime)) match {
        case Success(t) => Some(t)
        case Failure(_) => None
      }
    }
  }
}
