package week5

object HigherOrderListFunctions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)

  //filter produces a sublist containing all elements that satisfy the predicate.
  nums filter (x => x > 0)                        //> res0: List[Int] = List(2, 5, 7, 1)
  //The negation of filter.
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-4)
  /**
   * The 2 sublists produced by both filter and filterNot,
   * although doing it this way only requires a single traversal of the list
   */
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))

  /**
   * Write a function that squares each element of the list and returns the result.
   * The simple way of acheiving our aim is to use the higher-order list function, map,
   * which creates a new list by applying a function in turn to seach element of the receiver list
   */
  def square(xs: List[Int]): List[Int] = xs.map(x => x * x)
                                                  //> square: (xs: List[Int])List[Int]

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
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  /**
   * Using pack, write a function encode that produces the run-length encoding of a list
   */
  def encode[T](xs: List[T]): List[(T, Int)] =
    {
      pack(xs).map(ys => (ys.head, ys.length))
    }                                             //> encode: [T](xs: List[T])List[(T, Int)]
  val data = List("a", "a", "b", "c", "c", "a", "d")
                                                  //> data  : List[String] = List(a, a, b, c, c, a, d)
  pack(data)                                      //> res3: List[List[String]] = List(List(a, a), List(b), List(c, c), List(a), L
                                                  //| ist(d))
  encode(data)                                    //> res4: List[(String, Int)] = List((a,2), (b,1), (c,2), (a,1), (d,1))

  /**
   * Implement a function that reverses the elements of a list in terms of a higher-order fold list function.
   * Remark: The type parameter in List[T]() is necessary for type inference. Has complexity of O(n)
   */
  def reverse[T](xs: List[T]): List[T] =
    (xs foldLeft List[T]())((xs, x) => x :: xs)   //> reverse: [T](xs: List[T])List[T]

  reverse(data)                                   //> res5: List[String] = List(d, a, c, c, b, a, a)

  /**
   * Implement map and length on lists in terms of foldRight
   */
  def map[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((x, xs) => f(x) :: xs)
                                                  //> map: [T, U](xs: List[T], f: T => U)List[U]

  def length[T](xs: List[T]): Int =
    (xs foldRight 0)((x, xs) => xs + 1)           //> length: [T](xs: List[T])Int

  length(data)                                    //> res6: Int = 7
  map(data, (x: String) => x + "umb")             //> res7: List[String] = List(aumb, aumb, bumb, cumb, cumb, aumb, dumb)

}