package week6

object maps {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(57); 
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10);System.out.println("""romanNumerals  : scala.collection.immutable.Map[String,Int] = """ + $show(romanNumerals ));$skip(76); 
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern");System.out.println("""capitalOfCountry  : scala.collection.immutable.Map[String,String] = """ + $show(capitalOfCountry ));$skip(224); val res$0 = 
  /**
   * calling a map as a function on a non-existent key will rsult in an  error.
   * To attempt a lookup on a key we may not know beforehand, we can
   * use the get operation.
   */
  capitalOfCountry get ("Andorra");System.out.println("""res0: Option[String] = """ + $show(res$0));$skip(30); val res$1 = 
  capitalOfCountry get ("US")

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
};System.out.println("""res1: Option[String] = """ + $show(res$1));$skip(1265); 
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2);System.out.println("""p1  : week6.maps.Poly = """ + $show(p1 ));$skip(14); val res$2 = 
  p1.terms(7);System.out.println("""res2: Double = """ + $show(res$2));$skip(40); 
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0);System.out.println("""p2  : week6.maps.Poly = """ + $show(p2 ));$skip(12); val res$3 = 

  p1 + p2;System.out.println("""res3: week6.maps.Poly = """ + $show(res$3));$skip(21); val res$4 = 
  p1 foldLeftPlus p2;System.out.println("""res4: week6.maps.Poly = """ + $show(res$4))}
}
