package week5

object ListMethods {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(156); 

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x)
    case p :: ps => if (x <= p) x :: xs else p :: (insert(x, ps))
  };System.out.println("""insert: (x: Int, xs: List[Int])List[Int]""");$skip(268); 

  //Insertion sort method on a list, has worst case complexity n^2
  //because an I am wrapping an O(n) recursive call in another O(n) recursive call
  def iSort(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case p :: ps => insert(p, iSort(ps))
  };System.out.println("""iSort: (xs: List[Int])List[Int]""");$skip(285); 

  //Implementation of last - the list's last element or an exception if empty.
  //Has complexity O(n), compared to O(1) for head
  def last(xs: List[Int]): Int = xs match {
    case Nil => throw new Error("last of empty list")
    case List(p) => p
    case p :: ps => last(ps)
  };System.out.println("""last: (xs: List[Int])Int""");$skip(257); 

  //Implementaton of init - list containing all but the last element
  //Complexity O(n)
  def init(xs: List[Int]): List[Int] = xs match {
    case Nil => throw new Error("init of empty list")
    case List(p) => Nil
    case p :: ps => p :: init(ps)
  };System.out.println("""init: (xs: List[Int])List[Int]""");$skip(209); 

  //Concatenation of 2 lists. Has complexity O(n), where n is the size of xs
  def concat(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case Nil => ys
    case p :: ps => p :: concat(ps, ys)
  };System.out.println("""concat: (xs: List[Int], ys: List[Int])List[Int]""");$skip(187); 

  //complexity O(n^2), concat operation over a reverse operation.
  def reverse(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case p :: ps => reverse(ps) ++ List(p)
  };System.out.println("""reverse: (xs: List[Int])List[Int]""");$skip(115); 

  //Removes element at index n.
  def removeAt[T](xs: List[T], n: Int): List[T] = (xs take n) ++ (xs drop n + 1);System.out.println("""removeAt: [T](xs: List[T], n: Int)List[T]""");$skip(208); 

  //Flatten a list structure
  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => xs
    case (head: List[_]) :: ps => flatten(head) ::: flatten(ps)
    case p :: ps => p :: flatten(ps)
  };System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(743); 

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
  };System.out.println("""mSort: (xs: List[Int])List[Int]""");$skip(64); val res$0 = 

//Examples
  flatten(List(List(1, 1), 2, List(3, List(5, 8))));System.out.println("""res0: List[Any] = """ + $show(res$0));$skip(37); 
  var testList = List(1, 2, 3, 4, 5);System.out.println("""testList  : List[Int] = """ + $show(testList ));$skip(20); val res$1 = 
  reverse(testList);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(29); val res$2 = 
  concat(List(10), testList);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(17); val res$3 = 
  init(testList);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(27); val res$4 = 
  iSort(reverse(testList));System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(27); val res$5 = 
  mSort(reverse(testList));System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(17); val res$6 = 
  last(testList);System.out.println("""res6: Int = """ + $show(res$6))}

}