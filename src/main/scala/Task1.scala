/**
  * Created by Sergey on 07.02.2018.
  */
object Task1 extends App{
  val data: Array[String] = readLine().split(" ")

  var count: Int = data(0).toInt
  var analytics: Int = data(1).toInt
  var res = 0
  while(analytics < count / 3) {
    count += 1
    analytics += 1
    res += 1
  }
  println(res)
}
