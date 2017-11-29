package week5

object ListMethods {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x)
    case p :: ps => if (x <= p) x :: xs else p :: (insert(x, ps))
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]

  //Insertion sort method on a list, has worst case complexity n^2
  //because an I am wrapping an O(n) recursive call in another O(n) recursive call
  def iSort(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case p :: ps => insert(p, iSort(ps))
  }                                               //> iSort: (xs: List[Int])List[Int]

  //Implementation of last - the list's last element or an exception if empty.
  //Has complexity O(n), compared to O(1) for head
  def last(xs: List[Int]): Int = xs match {
    case Nil => throw new Error("last of empty list")
    case List(p) => p
    case p :: ps => last(ps)
  }                                               //> last: (xs: List[Int])Int

  //Implementaton of init - list containing all but the last element
  //Complexity O(n)
  def init(xs: List[Int]): List[Int] = xs match {
    case Nil => throw new Error("init of empty list")
    case List(p) => Nil
    case p :: ps => p :: init(ps)
  }                                               //> init: (xs: List[Int])List[Int]

  //Concatenation of 2 lists. Has complexity O(n), where n is the size of xs
  def concat(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case Nil => ys
    case p :: ps => p :: concat(ps, ys)
  }                                               //> concat: (xs: List[Int], ys: List[Int])List[Int]

  //complexity O(n^2), concat operation over a reverse operation.
  def reverse(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case p :: ps => reverse(ps) ++ List(p)
  }                                               //> reverse: (xs: List[Int])List[Int]

  //Removes element at index n.
  def removeAt[T](xs: List[T], n: Int): List[T] = (xs take n) ++ (xs drop n + 1)
                                                  //> removeAt: [T](xs: List[T], n: Int)List[T]

  //Flatten a list structure
  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => xs
    case (head: List[_]) :: ps => flatten(head) ::: flatten(ps)
    case p :: ps => p :: flatten(ps)
  }                                               //> flatten: (xs: List[Any])List[Any]

  /**
   * Scala implementation of merge sort algorithm.
   * 1. Take a list
   * 2. If it's empty or has a single element it is already sorted,
   * otherwise split it roughly down the middle.
   * 3. Sort the 2 sublists and merge them together.
   */
  def mSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = {
        (xs,ys) match {
          case (Nil,ys) => ys
          case (xs,Nil) => xs
          case(x :: xs1, y:: ys1) => if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
        }
      }
      //The lists are returned as a pair.
      val (fst, snd) = xs splitAt n
      merge(mSort(fst), mSort(snd))
    }
  }                                               //> mSort: (xs: List[Int])List[Int]

//Examples
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  var testList = List(1, 2, 3, 4, 5)              //> testList  : List[Int] = List(1, 2, 3, 4, 5)
  reverse(testList)                               //> res1: List[Int] = List(5, 4, 3, 2, 1)
  concat(List(10), testList)                      //> res2: List[Int] = List(10, 1, 2, 3, 4, 5)
  init(testList)                                  //> res3: List[Int] = List(1, 2, 3, 4)
  iSort(reverse(testList))                        //> res4: List[Int] = List(1, 2, 3, 4, 5)
  mSort(reverse(testList))                        //> res5: List[Int] = List(1, 2, 3, 4, 5)
  last(testList)                                  //> res6: Int = 5

}