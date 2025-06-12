import scala.io.Source
import scala.collection.mutable

object text2 {
  def main(args: Array[String]): Unit = {
    // 定义文件路径
    val filePath = "B:\\qypt\\IDEAwork\\Scala\\src\\word.txt"

    try {
      // 读取文件内容
      val source = Source.fromFile(filePath, "UTF-8")
      val content = source.getLines().mkString(" ").toLowerCase
      source.close()

      // 分词，假设单词由字母组成，使用正则表达式分割非字母字符
      val words = content.split("\\W+").filter(_.nonEmpty)

      // 统计词频
      val wordFrequency = mutable.Map[String, Int]().withDefaultValue(0)
      words.foreach(word => wordFrequency(word) += 1)

      // 找出词频最高的前三个单词
      val topThreeWords = wordFrequency.toSeq.sortBy(-_._2).take(3)

      // 找出回文单词
      val palindromeWords = words.distinct.filter(word => word == word.reverse)

      // 输出结果
      println("词频最高的前三个单词：")
      topThreeWords.foreach { case (word, freq) => println(s"$word: $freq") }

      println("\n回文单词：")
      palindromeWords.foreach(println)
    } catch {
      case e: Exception => println(s"发生错误：${e.getMessage}")
    }
  }
}