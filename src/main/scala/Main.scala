/**
  * Created by Sergey on 07.02.2018.
  */
object Main {

  def factorial(x: Int): Int = {
    def factorialIter(x: Int, acc: Int): Int = {
      if(x == 0) acc
      else factorialIter(x - 1, acc * x)
    }
    factorialIter(x, 1)
  }



  def main(args: Array[String]): Unit = {
    val data = scala.io.StdIn.readLine().split(" ")
    val N = data(0).toInt
    val K = data(1).toInt
    var res = 1
    (0 until K).foreach{
      x =>
        res = res * (N - x) * (N - x)
    }
    res = res / factorial(K)
    println(res)
  }
}
