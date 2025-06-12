

object text {
  def main(args: Array[String]): Unit ={
    //Scala常用数据处理方法
    //map映射
    def addNum: Int => Int = (x:Int) => x * 2
    val list1 = List(100,200,300).map(addNum)
    //省略参数类
    val list2 = List(100,200,300).map(x => x* 2)
    //当参数只出现一次，参数可省
    val list3 = List(100,200,300).map(_*2)
    println(list3)

    //分割 练习 字符串反转
    val s = "nab"
    println(s.reverse)

    val wordList =List("java","scala","cba")
    println(wordList.reverse)

        //求张三和李四低于6.0分的成绩门数和平均分
       val score = Array(("张三", Array(5.5, 6.6, 7.7, 8.8, 8.0)), ("李四", Array(6.0, 6.5, 7.0, 9.0,5.5)))
        score.map(x => (x._1, x._2.max)).foreach(println)
        score.map(y => (y._1, y._2.map(y => if (y >= 8.0) 1 else 0).sum)).foreach(println)
        score.map(y => (y._1, y._2.map(y => if (y < 6.0) 1 else 0).sum)).foreach(println)
        score.map(y => (y._1, y._2.count(y => y <6.0))).foreach(println)//简化方法
        //求平均 第一种
        score.map(sp => (sp._1,sp._2.sum / sp._2.length)).foreach(println)
        //第二种
        score.map { case (name, grades) =>
          val belowSix = grades.filter(_ > 0)
          val count = belowSix.length
          val avg = if (count > 0) belowSix.sum / count else 0.0
          (name, count, avg)
        }.foreach(println)


    //filter过滤 类型和元素不变
    val arr1 = Array(1,2,3,4,5,6)
    //偶数
    arr1.filter(t => t % 2 == 0).foreach(println)//第一种
    arr1.filter(t => if (t % 2 == 0) true else false).foreach(println)//第二种
    //奇数
    arr1.filter(_% 2==1).foreach(println)

    //练习：输出集合中的回文单词
    val arr2 =Array("I","love","you")
    arr2.filter(word => word == word.reverse).foreach(println)

  val wordFlat = List("i am hero","you are smart","i love scala")
  val wordSplit = wordFlat.map(_.split(""))
  val wordFlatten = wordSplit.flatten
  println(wordFlatten)

  val flatmapList = wordFlat.flatMap(_.split(""))
  println(flatmapList)

  //4.groupBy分组
  println(flatmapList.groupBy(_.charAt(0)).toList)
    val wordSam = flatmapList.groupBy(word => word)
    println(wordSam)

  }
}

