package week7

object streamRange {
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo + " ")
    if (lo >= hi) Stream.Empty else
      Stream.cons(lo, streamRange(lo + 1, hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]

  def listRange(lo: Int, hi: Int): List[Int] = {
    print(lo + " ")
    if (lo >= hi) Nil else
      lo :: listRange(lo + 1, hi)
  }                                               //> listRange: (lo: Int, hi: Int)List[Int]

  val stream1to10 = streamRange(1, 10)            //> 1 stream1to10  : Stream[Int] = Stream(1, ?)
  val list1to10 = listRange(1, 10)                //> 1 2 3 4 5 6 7 8 9 10 list1to10  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9
                                                  //| )
   
  stream1to10.take(3).toList                      //> 2 3 res0: List[Int] = List(1, 2, 3)
  list1to10.take(3)                               //> res1: List[Int] = List(1, 2, 3)
}