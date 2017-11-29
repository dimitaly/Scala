package week2

object tailRecursionEx {
  /**
   * Implement a tail-recursive form of factorial
   */
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc else loop(acc * n, n - 1)

    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  
  factorial(7)                                    //> res0: Int = 5040

  /**
   * Implement a tail-recursive sum function
   */
  def sum(f: Int => Int, a: Int, b: Int): Int =
    {
      def loop(acc: Int, a: Int): Int =
        if (a > b) acc
        else loop(acc + f(a), a + 1)

      loop(0, a)
    }                                             //> sum: (f: Int => Int, a: Int, b: Int)Int
    
    sum((x: Int) => x, 1, 10)                     //> res1: Int = 55
    
    
    
    
}