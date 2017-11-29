package week7
/**
 * All elements of a stream are computed only when they are needed to produce a
 * result. This opens up the possibility of being able to define infinite streams!
 */
object infiniteStreams {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]
  //The stream of all natural numbers
  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)

  //the stream of all multiples of 4
  val multiplesOf4 = nats map (_ * 4)             //> multiplesOf4  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
  val multiplesOf4UsingFilter = nats filter (_ % 4 == 0)
                                                  //> multiplesOf4UsingFilter  : scala.collection.immutable.Stream[Int] = Stream(0
                                                  //| , ?)

  //Take the first 100 elements of multiplesOf4 and call toList to force its evaluation.
  /**
   * The 1st operation is quicker to execute because we only have to evaluate
   * 20 elements of the stream to find the first twenty multiples of 4, as opposed
   * to 80 if using filter
   */
  multiplesOf4.take(20).toList                    //> res0: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 
                                                  //| 56, 60, 64, 68, 72, 76)
  multiplesOf4UsingFilter.take(20).toList         //> res1: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 
                                                  //| 56, 60, 64, 68, 72, 76)

  /**
   * The Sieve of Eratosthenes is an ancient technique to calculate prime numbers.
   * The idea is as follows:
   * 1. Start with all integers from 2, the first prime number.
   * 2. Elminate all multiples of 2
   * 3. The furst element of the resulting list is 3, a prime number.
   * 4. Eliminate all multiples of 3
   * 5. Repeat indefinitely to generate an ascending sequence of all prime numbers.
   */
  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]

  val primes = sieve(from(2))                     //> primes  : Stream[Int] = Stream(2, ?)
  primes.take(100).toList                         //> res2: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 
                                                  //| 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 1
                                                  //| 31, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 2
                                                  //| 11, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 2
                                                  //| 93, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 3
                                                  //| 89, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 4
                                                  //| 79, 487, 491, 499, 503, 509, 521, 523, 541)
  /**
   * In week2.findingFixedPoints.sc, our algorithm for square roots always used an isGoodEnough
   * test to tell when to terminate the iteration.
   * With streams we can now express the concept of a converging
   * sequence without having to worry about when to terminate it:
   * The definition of guesses may look alarming, as it appears that we are applying a map on a value
   * we have yet to define, which will get us stuck in an infinite recursive loop.
   * However, because this expression is the right hand operand of a (#::) Stream constructor, we
   * can avoid this problem.
   */
  def sqrtStream(x: Double): Stream[Double] =
    {
      def improve(guess: Double) = (guess + x / guess) / 2
      lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
      guesses
    }                                             //> sqrtStream: (x: Double)Stream[Double]

	sqrtStream(4).tail.tail                   //> res3: scala.collection.immutable.Stream[Double] = Stream(2.05, ?)
  sqrtStream(4).take(10).toList                   //> res4: List[Double] = List(1.0, 2.5, 2.05, 2.000609756097561, 2.000000092922
                                                  //| 2947, 2.000000000000002, 2.0, 2.0, 2.0, 2.0)

  def isGoodEnough(guess: Double, x: Double) = (Math.abs(guess * guess - x) / x) < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean

  sqrtStream(4).filter(isGoodEnough(_, 4)).take(10).toList
                                                  //> res5: List[Double] = List(2.0000000929222947, 2.000000000000002, 2.0, 2.0, 
                                                  //| 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)
}