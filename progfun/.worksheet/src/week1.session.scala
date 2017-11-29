package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet");$skip(6); val res$0 = 
  1+2;System.out.println("""res0: Int(3) = """ + $show(res$0));$skip(380); 


  def sqrt(x: Double) = {
    
    def abs(x: Double) =
      if (x >= 0) x else -x
    
    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x <= 0.0001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(17); val res$1 = 
  
  sqrt(0.001);System.out.println("""res1: Double = """ + $show(res$1));$skip(16); val res$2 = 
  sqrt(0.1e-20);System.out.println("""res2: Double = """ + $show(res$2));$skip(15); val res$3 = 
  sqrt(1.0e20);System.out.println("""res3: Double = """ + $show(res$3));$skip(15); val res$4 = 
  sqrt(1.0e50);System.out.println("""res4: Double = """ + $show(res$4))}
  
}