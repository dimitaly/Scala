package week2

/**
 * Write a function that finds the fixed point of another function,
 * i.e. a solution to the problem f(x) = x. The approach is to apply
 * f iteratively to some initial value of x until it conerges to some fixed value
 */
object findingFixedPoints {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val tolerance = 0.001                           //> tolerance  : Double = 0.001

  def isCloseEnough(x: Double, y: Double): Boolean = Math.abs((x - y) / x) < 0.001
                                                  //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(initialGuess: Double): Double =
    {
      println(" guess is " + initialGuess)
      val next = f(initialGuess)
      if (isCloseEnough(initialGuess, next)) initialGuess else fixedPoint(f)(next)
    }                                             //> fixedPoint: (f: Double => Double)(initialGuess: Double)Double

  fixedPoint(x => 0.435 * x + 0.5)(0.3)           //>  guess is 0.3
                                                  //|  guess is 0.6305000000000001
                                                  //|  guess is 0.7742675
                                                  //|  guess is 0.8368063625
                                                  //|  guess is 0.8640107676875
                                                  //|  guess is 0.8758446839440626
                                                  //|  guess is 0.8809924375156672
                                                  //|  guess is 0.8832317103193152
                                                  //|  guess is 0.8842057939889021
                                                  //| res0: Double = 0.8842057939889021
  /**
   * Sqrt(x) is the fixed point of the function y => y/x.
   * Unfortunately, simply using this function will cause the guess to oscillate and
   * we won't have convergence ( try this with the root of 2). By averaging the guess between successive iterations,
   * this oscillation can be damped, resulting in a convergent iteration.
   */
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)
                                                  //> sqrt: (x: Double)Double
  /**
   * With the damping in place the sqrt of 2 can be evaluates
   */
  sqrt(2)                                         //>  guess is 1.0
                                                  //|  guess is 1.5
                                                  //|  guess is 1.4166666666666665
                                                  //|  guess is 1.4142156862745097
                                                  //| res1: Double = 1.4142156862745097

  /**
   * How can we abstract out this damping function so iit can be reused
   */
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  def fixedPointWithAverageDamp(f: Double => Double)(firstGuess: Double): Double =
    fixedPoint(averageDamp(f))(firstGuess)        //> fixedPointWithAverageDamp: (f: Double => Double)(firstGuess: Double)Double
                                                  //| 

  def altSqrt(x: Double) = fixedPointWithAverageDamp(y => x/y)(1)
                                                  //> altSqrt: (x: Double)Double

  altSqrt(2)                                      //>  guess is 1.0
                                                  //|  guess is 1.5
                                                  //|  guess is 1.4166666666666665
                                                  //|  guess is 1.4142156862745097
                                                  //| res2: Double = 1.4142156862745097
}