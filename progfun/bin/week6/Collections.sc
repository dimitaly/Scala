package week6

object Collections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)

  val s = "Hello World"                           //> s  : String = Hello World
  def upperFilter(char: Char): Boolean = char.isUpper
                                                  //> upperFilter: (char: Char)Boolean
  s filter (upperFilter)                          //> res1: String = HW
  s exists (upperFilter)                          //> res2: Boolean = true
  s forall (upperFilter)                          //> res3: Boolean = false

  /**
   * Zip takes 2 sequences and returns a single sequence that contains pairs, where the nth
   * pair contains the nth elements from both the original sequences. It is as if both sequences have come together, much like a zip brings 2 strands together into a pair of tightly joined strands.
   */
  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  /**
   * The inverse of ziop
   */
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))

  /**
   * Applies collection-valued function to all elements and concatenates the results.
   */
  s flatMap (c => List(c, '.'))                   //> res5: String = H.e.l.l.o. .W.o.r.l.d.

  xs.sum                                          //> res6: Int = 50
  xs.max                                          //> res7: Int = 44

  // How do we list all combinations of numbers, x and y, where x is drawn from 1..M and y is drawn from 1..N?
  val M = 5                                       //> M  : Int = 5
  val N = 6                                       //> N  : Int = 6

  (1 to M) flatMap (x => (1 to N) map (y => (x, y)))
                                                  //> res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,
                                                  //| 2), (1,3), (1,4), (1,5), (1,6), (2,1), (2,2), (2,3), (2,4), (2,5), (2,6), (
                                                  //| 3,1), (3,2), (3,3), (3,4), (3,5), (3,6), (4,1), (4,2), (4,3), (4,4), (4,5),
                                                  //|  (4,6), (5,1), (5,2), (5,3), (5,4), (5,5), (5,6))

  //To compute the scalar product of 2 vectors
  def scalar(v1: Vector[Double], v2: Vector[Double]): Double = (v1 zip v2).map { case (x, y) => x * y }.sum
                                                  //> scalar: (v1: Vector[Double], v2: Vector[Double])Double

  scalar(Vector(1, 2, 3), Vector(4, 5, 6))        //> res9: Double = 32.0
  
}