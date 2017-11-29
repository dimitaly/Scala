package week2

object currying {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //Define a function that returns the product of another function from a to b
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b) //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 4)                       //> res0: Int = 144

  //define factorial in terms of product
  def factorial(n: Int) = product(x => x)(1, n)   //> factorial: (n: Int)Int

  factorial(5)                                    //> res1: Int = 120

  //define a generalised function that implements both sum and product
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  //test with product
  mapReduce(x => x * x, (x, y) => x * y, 1)(3, 4) //> res2: Int = 144

  //test with sum
  mapReduce(x => x * x, (x, y) => x + y, 0)(3, 4) //> res3: Int = 25

}