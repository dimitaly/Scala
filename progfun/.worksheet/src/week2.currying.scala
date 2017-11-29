package week2

object currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(183); 

  //Define a function that returns the product of another function from a to b
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$0 = 

  product(x => x * x)(3, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(91); 

  //define factorial in terms of product
  def factorial(n: Int) = product(x => x)(1, n);System.out.println("""factorial: (n: Int)Int""");$skip(17); val res$1 = 

  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(244); 

  //define a generalised function that implements both sum and product
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(72); val res$2 = 
  //test with product
  mapReduce(x => x * x, (x, y) => x * y, 1)(3, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(70); val res$3 = 

  //test with sum
  mapReduce(x => x * x, (x, y) => x + y, 0)(3, 4);System.out.println("""res3: Int = """ + $show(res$3))}

}