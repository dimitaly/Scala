package week5

object HigherOrderListFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  println("Welcome to the Scala worksheet");$skip(36); 

  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(111); val res$0 = 

  //filter produces a sublist containing all elements that satisfy the predicate.
  nums filter (x => x > 0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(58); val res$1 = 
  //The negation of filter.
  nums filterNot (x => x > 0);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(178); val res$2 = 
  /**
   * The 2 sublists produced by both filter and filterNot,
   * although doing it this way only requires a single traversal of the list
   */
  nums partition (x => x > 0);System.out.println("""res2: (List[Int], List[Int]) = """ + $show(res$2));$skip(345); 

  /**
   * Write a function that squares each element of the list and returns the result.
   * The simple way of acheiving our aim is to use the higher-order list function, map,
   * which creates a new list by applying a function in turn to seach element of the receiver list
   */
  def square(xs: List[Int]): List[Int] = xs.map(x => x * x);System.out.println("""square: (xs: List[Int])List[Int]""");$skip(637); 

  /**
   * Write a function pack that packs consequtive duplicates of list elements
   * into sublists. span partitions the list into 2 sublists: the list coonstaining consecutive
   * elements that satisfy the condition and the remainder of the list. In other words, span is the
   * union of takeWhile and dropWhile, though it acheives this in a single traversal of the list, not the
   * 2 traversals required for both takeWhile and dropWhile.
   */
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
    }
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(209); 

  /**
   * Using pack, write a function encode that produces the run-length encoding of a list
   */
  def encode[T](xs: List[T]): List[(T, Int)] =
    {
      pack(xs).map(ys => (ys.head, ys.length))
    };System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(53); 
  val data = List("a", "a", "b", "c", "c", "a", "d");System.out.println("""data  : List[String] = """ + $show(data ));$skip(13); val res$3 = 
  pack(data);System.out.println("""res3: List[List[String]] = """ + $show(res$3));$skip(15); val res$4 = 
  encode(data);System.out.println("""res4: List[(String, Int)] = """ + $show(res$4));$skip(314); 

  /**
   * Implement a function that reverses the elements of a list in terms of a higher-order fold list function.
   * Remark: The type parameter in List[T]() is necessary for type inference. Has complexity of O(n)
   */
  def reverse[T](xs: List[T]): List[T] =
    (xs foldLeft List[T]())((xs, x) => x :: xs);System.out.println("""reverse: [T](xs: List[T])List[T]""");$skip(18); val res$5 = 

  reverse(data);System.out.println("""res5: List[String] = """ + $show(res$5));$skip(178); 

  /**
   * Implement map and length on lists in terms of foldRight
   */
  def map[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((x, xs) => f(x) :: xs);System.out.println("""map: [T, U](xs: List[T], f: T => U)List[U]""");$skip(78); 

  def length[T](xs: List[T]): Int =
    (xs foldRight 0)((x, xs) => xs + 1);System.out.println("""length: [T](xs: List[T])Int""");$skip(17); val res$6 = 

  length(data);System.out.println("""res6: Int = """ + $show(res$6));$skip(38); val res$7 = 
  map(data, (x: String) => x + "umb");System.out.println("""res7: List[String] = """ + $show(res$7))}

}
