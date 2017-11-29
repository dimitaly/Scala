package week6

object Collections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(30); 
  val xs = Array(1, 2, 3, 44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(22); val res$0 = 
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(26); 

  val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(54); 
  def upperFilter(char: Char): Boolean = char.isUpper;System.out.println("""upperFilter: (char: Char)Boolean""");$skip(25); val res$1 = 
  s filter (upperFilter);System.out.println("""res1: String = """ + $show(res$1));$skip(25); val res$2 = 
  s exists (upperFilter);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(25); val res$3 = 
  s forall (upperFilter);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(338); 

  /**
   * Zip takes 2 sequences and returns a single sequence that contains pairs, where the nth
   * pair contains the nth elements from both the original sequences. It is as if both sequences have come together, much like a zip brings 2 strands together into a pair of tightly joined strands.
   */
  val pairs = List(1, 2, 3) zip s;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(51); val res$4 = 
  /**
   * The inverse of ziop
   */
  pairs.unzip;System.out.println("""res4: (List[Int], List[Char]) = """ + $show(res$4));$skip(132); val res$5 = 

  /**
   * Applies collection-valued function to all elements and concatenates the results.
   */
  s flatMap (c => List(c, '.'));System.out.println("""res5: String = """ + $show(res$5));$skip(11); val res$6 = 

  xs.sum;System.out.println("""res6: Int = """ + $show(res$6));$skip(9); val res$7 = 
  xs.max;System.out.println("""res7: Int = """ + $show(res$7));$skip(125); 

  // How do we list all combinations of numbers, x and y, where x is drawn from 1..M and y is drawn from 1..N?
  val M = 5;System.out.println("""M  : Int = """ + $show(M ));$skip(12); 
  val N = 6;System.out.println("""N  : Int = """ + $show(N ));$skip(55); val res$8 = 

  (1 to M) flatMap (x => (1 to N) map (y => (x, y)));System.out.println("""res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$8));$skip(157); 

  //To compute the scalar product of 2 vectors
  def scalar(v1: Vector[Double], v2: Vector[Double]): Double = (v1 zip v2).map { case (x, y) => x * y }.sum;System.out.println("""scalar: (v1: Vector[Double], v2: Vector[Double])Double""");$skip(45); val res$9 = 

  scalar(Vector(1, 2, 3), Vector(4, 5, 6));System.out.println("""res9: Double = """ + $show(res$9))}
  
}
