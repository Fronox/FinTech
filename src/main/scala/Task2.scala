/**
  * Created by Sergey on 07.02.2018.
  */
object Task2{
  def main(args: Array[String]): Unit = {
    val data = scala.io.StdIn.readLine
    val splitData = data.replaceAll("[\\p{Punct}]", "").split(" ")
    val maxWord = splitData.maxBy(x => x.length).length
    val res = data.map{
      c =>
        if(c > 96 && c < 123){
          var rowRes = c + maxWord
          while (rowRes >= 123) rowRes -= 26
          rowRes.toChar
        }
        else if (c > 64 && c < 91){
          var rowRes = c + maxWord
          while (rowRes >= 91) rowRes -= 26
          rowRes.toChar
        }
        else c
    }
    res.foreach(print(_))
  }
}
