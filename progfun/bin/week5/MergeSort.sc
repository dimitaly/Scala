package week5

import scala.math.Ordering

object MergeSort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  /**
   * How can we parameterize the Merge Sort implementation in ListMethods.sc
   * so that it can work over all lists? This requires the addition of another parameter
   * that defines how to compare 2 elements of the list i.e. provides a definition for the < operator
   * where one may not exist for the type in question. We can provide our own comparator e.g.
   * def msort[T](xs: List[T])(lt: (T, T) => Boolean) = {...}, although Scala already provides a class
   * for comparing elements of type T, called Ordering. We could paramaterize with this instead
   * e.g. def msort[T](xs: List[T])(ord : Ordering)
   * By marking this as an implicit parameter, we can leave it to the compiler to infer which Ordering instance to pass in
   * when calling mSort, based on the type bound to the parameter T.
   */
   
    def mSort[T](xs: List[T])(implicit ord : Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs,ys) match {
          case (Nil,ys) => ys
          case (xs,Nil) => xs
          case(x :: xs1, y:: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
        }
      }
      //The lists are returned as a pair.
      val (fst, snd) = xs splitAt n
      //Don't have to pass in the ordering parameter here, it uses the same one that is implicitly passed
      //in at the point of the function call.
      merge(mSort(fst), mSort(snd))
    }
  }                                               //> mSort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]
  
  val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[java.lang.String] = List(apple, pear, orange, pineapple)
  //Here the compiler inplicitly passes the commpanion object of Ordering associated with
  //the String type.
  mSort(fruit)                                    //> res0: List[java.lang.String] = List(apple, orange, pear, pineapple)

}