package week3

object Rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = new Rational(1, 3)                      //> x  : week3.Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  -x                                              //> res2: week3.Rational = 1/-3

  val y = new Rational(5, 7)                      //> y  : week3.Rational = 5/7
  x + y                                           //> res3: week3.Rational = 22/21

  val z = new Rational(3, 2)                      //> z  : week3.Rational = 3/2

  x - y - z                                       //> res4: week3.Rational = -79/42
  x < y                                           //> res5: Boolean = true
  x.max(y)                                        //> res6: week3.Rational = 5/7
  val strange = new Rational(1, 0)                //> java.lang.IllegalArgumentException: requirement failed: denominator must be 
                                                  //| nonzero!
                                                  //| 	at scala.Predef$.require(Predef.scala:233)
                                                  //| 	at week3.Rational.<init>(week3.Rationals.scala:25)
                                                  //| 	at week3.Rationals$$anonfun$main$1.apply$mcV$sp(week3.Rationals.scala:18
                                                  //| )
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.Rationals$.main(week3.Rationals.scala:3)
                                                  //| 	at week3.Rationals.main(week3.Rationals.scala)
  strange + strange

  new Rational(2)
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero!")

  def this(x: Int) = this(x, 1)
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def +(that: Rational) = new Rational(numer * that.denom + denom * that.numer, denom * that.denom)
  def *(that: Rational) = new Rational(numer * that.numer, denom * that.denom)
  def unary_- : Rational = new Rational(-numer, denom)
  def -(that: Rational) = this + -that
  def <(that: Rational) = numer * that.denom < that.numer * denom
  def max(that: Rational) = if (this < that) that else this
  override def toString = numer + "/" + denom

}