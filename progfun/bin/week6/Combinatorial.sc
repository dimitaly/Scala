package week6

object Combinatorial {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  /**
   * A number n is prime if the only divisors of n are 1 and n itself.
   * What is a high-level way to write a test for primality of numbers?
   * For once, value conciseness over efficiency.
   */
  def isPrime(n: Integer): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Integer)Boolean

  /**
   * given a positive integer, n, find all pairs (i,j) where 1 <j<i< n and i+j is prime.
   * You will find that this implementation will return a vector because the type Range cannot hold pairs,
   * so the type inferencer goes up the hierarchy to look for the next available type that may accomodate the return data.
   * In this case, the immediate superclass of Range is IndexedSeq (the base class for all random access sequences),
   * and the most economical implementation of this
   * that fits the bill is Vector
   */
  val n = 7                                       //> n  : Int = 7
  val pairSequence = (1 until n) map (i => (1 until i) map (j => (i, j)))
                                                  //> pairSequence  : scala.collection.immutable.IndexedSeq[scala.collection.immut
                                                  //| able.IndexedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1),
                                                  //|  (3,2)), Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Ve
                                                  //| ctor((6,1), (6,2), (6,3), (6,4), (6,5)))

  /**We can flatten the result using either foldright with the concatenation operator*/
  //val flattenedUsingFoldright = (pairSequence foldRight Seq[Int, Int]())(_ ++ _)

  /**
   * Or, equivalently, we can use the built-in function, flatten.
   * Flatten concatenates a Sequence of collections into a single collection.
   */
  val flattenedUsingFlatten = pairSequence.flatten//> flattenedUsingFlatten  : scala.collection.immutable.IndexedSeq[(Int, Int)] 
                                                  //| = Vector((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,
                                                  //| 4), (6,1), (6,2), (6,3), (6,4), (6,5))

  /**
   * It is worth noting that xs flatMap f is equivalent to (xs map f).flatten.
   * This means we can revise our original definition of pairSequence to immediately return
   * a flattened sequence of pairs.
   */
  val flattenedPairSequence = (1 until n) flatMap (i => (1 until i) map (j => (i, j)))
                                                  //> flattenedPairSequence  : scala.collection.immutable.IndexedSeq[(Int, Int)] 
                                                  //| = Vector((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,
                                                  //| 4), (6,1), (6,2), (6,3), (6,4), (6,5))
  val primePairs = flattenedPairSequence filter (pair => isPrime(pair._1 + pair._2))
                                                  //> primePairs  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2
                                                  //| ,1), (3,2), (4,1), (4,3), (5,2), (6,1), (6,5))
  /**
   * Whilst higher-order functions are often useful, the level of abstraction required can make it hard too understand
   * what the program is doing. Here, there was a need to break up the implementation into several stepsm using intermediate
   * variables to make it more understandable. For-expressions work to alleviate this problem by providing a higher level construct
   * for our expressions. We will reimplement findPrimePairs using a single expression. *
   */
  for {
    i <- 1 until n
    j <- 1 until i
    if (isPrime(i + j))
  } yield (i, j)                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5))
  //Write an implementation of Scalar that makes use of a for
   def scalar(xs: Vector[Double], ys: Vector[Double]): Double = (for ((x,y) <- xs zip ys) yield x * y).sum
                                                  //> scalar: (xs: Vector[Double], ys: Vector[Double])Double
   
   scalar(Vector(1, 2, 3), Vector(4, 5, 6))       //> res1: Double = 32.0
   }