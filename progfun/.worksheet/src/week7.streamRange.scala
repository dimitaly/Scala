package week7

object streamRange {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(195); 
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo + " ")
    if (lo >= hi) Stream.Empty else
      Stream.cons(lo, streamRange(lo + 1, hi))
  };System.out.println("""streamRange: (lo: Int, hi: Int)Stream[Int]""");$skip(135); 

  def listRange(lo: Int, hi: Int): List[Int] = {
    print(lo + " ")
    if (lo >= hi) Nil else
      lo :: listRange(lo + 1, hi)
  };System.out.println("""listRange: (lo: Int, hi: Int)List[Int]""");$skip(40); 

  val stream1to10 = streamRange(1, 10);System.out.println("""stream1to10  : Stream[Int] = """ + $show(stream1to10 ));$skip(35); 
  val list1to10 = listRange(1, 10);System.out.println("""list1to10  : List[Int] = """ + $show(list1to10 ));$skip(33); val res$0 = 
   
  stream1to10.take(3).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(20); val res$1 = 
  list1to10.take(3);System.out.println("""res1: List[Int] = """ + $show(res$1))}
}
