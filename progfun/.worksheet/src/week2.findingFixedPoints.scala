package week2

/**
 * Write a function that finds the fixed point of another function,
 * i.e. a solution to the problem f(x) = x. The approach is to apply
 * f iteratively to some initial value of x until it conerges to some fixed value
 */
object findingFixedPoints {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(314); 
  println("Welcome to the Scala worksheet");$skip(26); 

  val tolerance = 0.001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(85); 

  def isCloseEnough(x: Double, y: Double): Boolean = Math.abs((x - y) / x) < 0.001;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(243); 

  def fixedPoint(f: Double => Double)(initialGuess: Double): Double =
    {
      println(" guess is " + initialGuess)
      val next = f(initialGuess)
      if (isCloseEnough(initialGuess, next)) initialGuess else fixedPoint(f)(next)
    };System.out.println("""fixedPoint: (f: Double => Double)(initialGuess: Double)Double""");$skip(42); val res$0 = 

  fixedPoint(x => 0.435 * x + 0.5)(0.3);System.out.println("""res0: Double = """ + $show(res$0));$skip(406); 
  /**
   * Sqrt(x) is the fixed point of the function y => y/x.
   * Unfortunately, simply using this function will cause the guess to oscillate and
   * we won't have convergence ( try this with the root of 2). By averaging the guess between successive iterations,
   * this oscillation can be damped, resulting in a convergent iteration.
   */
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1);System.out.println("""sqrt: (x: Double)Double""");$skip(84); val res$1 = 
  /**
   * With the damping in place the sqrt of 2 can be evaluates
   */
  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(153); 

  /**
   * How can we abstract out this damping function so iit can be reused
   */
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(126); 
  def fixedPointWithAverageDamp(f: Double => Double)(firstGuess: Double): Double =
    fixedPoint(averageDamp(f))(firstGuess);System.out.println("""fixedPointWithAverageDamp: (f: Double => Double)(firstGuess: Double)Double""");$skip(68); 

  def altSqrt(x: Double) = fixedPointWithAverageDamp(y => x/y)(1);System.out.println("""altSqrt: (x: Double)Double""");$skip(15); val res$2 = 

  altSqrt(2);System.out.println("""res2: Double = """ + $show(res$2))}
}