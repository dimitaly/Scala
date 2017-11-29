package week7
/**
 * All elements of a stream are computed only when they are needed to produce a
 * result. This opens up the possibility of being able to define infinite streams!
 */
object infiniteStreams {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(261); 
  def from(n: Int): Stream[Int] = n #:: from(n + 1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(59); 
  //The stream of all natural numbers
  val nats = from(0);System.out.println("""nats  : Stream[Int] = """ + $show(nats ));$skip(77); 

  //the stream of all multiples of 4
  val multiplesOf4 = nats map (_ * 4);System.out.println("""multiplesOf4  : scala.collection.immutable.Stream[Int] = """ + $show(multiplesOf4 ));$skip(57); 
  val multiplesOf4UsingFilter = nats filter (_ % 4 == 0);System.out.println("""multiplesOf4UsingFilter  : scala.collection.immutable.Stream[Int] = """ + $show(multiplesOf4UsingFilter ));$skip(322); val res$0 = 

  //Take the first 100 elements of multiplesOf4 and call toList to force its evaluation.
  /**
   * The 1st operation is quicker to execute because we only have to evaluate
   * 20 elements of the stream to find the first twenty multiples of 4, as opposed
   * to 80 if using filter
   */
  multiplesOf4.take(20).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(42); val res$1 = 
  multiplesOf4UsingFilter.take(20).toList;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(514); 

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
    s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(32); 

  val primes = sieve(from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(26); val res$2 = 
  primes.take(100).toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(802); 
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
    };System.out.println("""sqrtStream: (x: Double)Stream[Double]""");$skip(26); val res$3 = 

	sqrtStream(4).tail.tail;System.out.println("""res3: scala.collection.immutable.Stream[Double] = """ + $show(res$3));$skip(32); val res$4 = 
  sqrtStream(4).take(10).toList;System.out.println("""res4: List[Double] = """ + $show(res$4));$skip(92); 

  def isGoodEnough(guess: Double, x: Double) = (Math.abs(guess * guess - x) / x) < 0.0001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(61); val res$5 = 

  sqrtStream(4).filter(isGoodEnough(_, 4)).take(10).toList;System.out.println("""res5: List[Double] = """ + $show(res$5))}
}
