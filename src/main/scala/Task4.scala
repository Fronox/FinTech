import scala.collection.mutable.ArrayBuffer

/**
  * Created by Sergey on 07.02.2018.
  */
object Task4 {
  def main(args: Array[String]): Unit = {
    val size = scala.io.StdIn.readLine().split(" ")
    val n = size(0).toInt
    val figure = (0 until n).map(_ => scala.io.StdIn.readLine().split(" ").map(x => x.toInt))
    var figuresBounds = ArrayBuffer[ArrayBuffer[(Int, Int)]]()
    (0 until n).foreach(_ => figuresBounds += ArrayBuffer[(Int, Int)]())
    figure.indices.foreach{
      i =>
        val row = figure(i)
        var start = -1
        for (j <- row.indices) {
          if(row(j) == 0){
            if(start == -1) start = j
          }
          else{
            if(start != -1) {
              figuresBounds(i) += ((start, j))
              start = -1
            }
          }
        }
        if(start != -1) figuresBounds(i) += ((start, row.length))
    }
    val res = figuresBounds.flatten.distinct.length
    println(res)
  }
}
