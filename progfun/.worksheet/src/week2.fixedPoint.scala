package week2

/*
 * Write a function that finds the fixed point of another function,
 * i.e. a solution to the problem f(x) = x. The approach is to apply
 * f iteratively to some initial value of x until it conerges to some fixed value
 */
object fixedPoint {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(305); 
  println("Welcome to the Scala worksheet");$skip(27); 
  
  val tolerance = 0.001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(84); 
  
  def isCloseEnough(x: Double, y: Double) : Boolean = Math.abs((x-y)/x)  < 0.001;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(191); 
  
  def fixedPoints(f: Double => Double)(initialGuess: Double): Double =
  {
  val next = f(initialGuess)
  if (isCloseEnough(initialGuess, next)) initialGuess else fixedPoints(f)(next)
  };System.out.println("""fixedPoints: (f: Double => Double)(initialGuess: Double)Double""");$skip(45); val res$0 = 
  
  fixedPoints(x => 0.435 * x + 0.5) (0.3);System.out.println("""res0: Double = """ + $show(res$0));$skip(35); 
 
 def sqrt(x: Double) = fixedPoin;System.out.println("""sqrt: (x: Double)<error>""")}
}