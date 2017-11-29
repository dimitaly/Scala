package week2

object tailRecursionEx {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(242); 
  /**
   * Implement a tail-recursive form of factorial
   */
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc else loop(acc * n, n - 1)

    loop(1, n)
  };System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$0 = 
  
  factorial(7);System.out.println("""res0: Int = """ + $show(res$0));$skip(238); 

  /**
   * Implement a tail-recursive sum function
   */
  def sum(f: Int => Int, a: Int, b: Int): Int =
    {
      def loop(acc: Int, a: Int): Int =
        if (a > b) acc
        else loop(acc + f(a), a + 1)

      loop(0, a)
    };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(35); val res$1 = 
    
    sum((x: Int) => x, 1, 10);System.out.println("""res1: Int = """ + $show(res$1))}
    
    
    
    
}
