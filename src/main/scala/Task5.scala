import scala.collection.mutable

/**
  * Created by Sergey on 07.02.2018.
  */
object Task5 {
  def main(args: Array[String]): Unit = {
    val N = scala.io.StdIn.readInt()
    val times = scala.io.StdIn.readLine().split(" ").map(x => x.toInt)
    val M = scala.io.StdIn.readInt()
    val vertexSet = 1 to N
    val routesData = (0 until M).map{
      x =>
        val buff = scala.io.StdIn.readLine().split(" ")
        (buff(0).toInt, buff(1).toInt)

    }
    val timesMap = vertexSet.map{
      i =>
        i -> times(i - 1)
    }.toMap
    var routesMap = mutable.HashMap[Int, List[Int]]()
    routesData.foreach{
      case (k, v) =>
        val currVal = routesMap.getOrElseUpdate(k, List())
        routesMap += k -> currVal.:+(v)
    }
    routesMap += N -> List()
    var minRoutesMap = mutable.HashMap[Int, String]()
    var nonActiveVertex = mutable.Set[Int]()
    minRoutesMap += 1 -> "0"
    vertexSet.tail.foreach(x => minRoutesMap += x -> "Inf")
    while(nonActiveVertex.size != N) {
      val v = minRoutesMap.filterNot(x => nonActiveVertex.contains(x._1)).minBy(x => x._2)._1
      nonActiveVertex += v
      for(u <- vertexSet if routesMap(v).contains(u)){
        val newRouteLen =  (minRoutesMap(v).toInt + timesMap(v)).toString
        if(minRoutesMap(u) > newRouteLen) {
          if(minRoutesMap(u) != "Inf") nonActiveVertex -= u
          minRoutesMap += u -> newRouteLen
        }
      }
    }
    println(if (minRoutesMap(N) == "Inf") -1 else minRoutesMap(N))
  }
}
