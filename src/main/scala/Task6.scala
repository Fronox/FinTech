/**
  * Created by Sergey on 07.02.2018.
  */
object Task6{
  def main(args: Array[String]): Unit = {
    val data = scala.io.StdIn.readLine()
    var res = 0
    for (i <- 0 until data.length) {
      for (j <- i + 1 to data.length) {
        val str = data.substring(i, j)
        if(str == str.reverse) res += 1
      }
    }
    println(res)
  }
}
