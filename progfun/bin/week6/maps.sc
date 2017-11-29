package week6

object maps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V 
                                                  //| -> 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  /**
   * calling a map as a function on a non-existent key will rsult in an  error.
   * To attempt a lookup on a key we may not know beforehand, we can
   * use the get operation.
   */
  capitalOfCountry get ("Andorra")                //> res0: Option[String] = None
  capitalOfCountry get ("US")                     //> res1: Option[String] = Some(Washington)

  /**
   * define a class Poly that represents polynomials with must define a + operator that
   * returns a new Poly which is the sum of the 2 operands.
   */

  class Poly(val terms0: Map[Int, Double]) {
    /** this overloaded constructor takes an arbitrary number of pairs, signified by the * wildcard */
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    /**
     * maps are partial functions. Applying a map to a non-existent key throws an expception.
     * The operation withDefaultValue turns a map into a total function
     */
    val terms = terms0 withDefaultValue (0.0)
    override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
    def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }
  //Alternative implementation of + that's based on foldLeft.
	def foldLeftPlus(other: Poly) = new Poly((other.terms foldLeft terms) (addTerm))
	def addTerm(terms: Map[Int, Double], term: (Int, Double)):Map[Int, Double] =
	{
	 val (exp, coeff) = term
     terms+ (exp -> (coeff + terms(exp)))
  }
}
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : week6.maps.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  p1.terms(7)                                     //> res2: Double = 0.0
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : week6.maps.Poly = 7.0x^3 + 3.0x^0

  p1 + p2                                         //> res3: week6.maps.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
  p1 foldLeftPlus p2                              //> res4: week6.maps.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
}