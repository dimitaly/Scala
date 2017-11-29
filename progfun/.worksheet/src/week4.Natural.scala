package week4


object Natural {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet")

  /**
   * Implement the set of natural numbers using only classes
   */
  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor = new Succ(this)
    def +(that: Nat): Nat
    def -(that: Nat): Nat
  }

  object Zero extends Nat {
    def isZero = true
    def predecessor = throw new NoSuchElementException
    def +(that: Nat) = that
    def -(that: Nat) = if (that.isZero) Zero else throw new NoSuchElementException
  }

  class Succ(n: Nat) extends Nat {
    def isZero = false
    def predecessor = n
    def +(that: Nat) = (this.predecessor + that).successor
    def -(that: Nat) = if (that.isZero) this else n - that.predecessor
  }
  
  abstract class BooleanClass {
  def ifThenElse[T](t : T, e : T) : T
  def &&(other : BooleanClass) : BooleanClass = ifThenElse(other, False)
  def ||(other : BooleanClass) : BooleanClass = ifThenElse(True, other)
  def unary_! : BooleanClass = ifThenElse(True, False)
  def ==(other: BooleanClass) = ifThenElse(other, other.unary_!)
  def !=(other: BooleanClass) = ifThenElse(other.unary_!, other)
  def <(other: BooleanClass) = ifThenElse(False, other)
  }
  
  object True extends BooleanClass
  {
  def ifThenElse[T](t : T, e : T) = t
  }
  
   object False extends BooleanClass
  {
  def ifThenElse[T](t : T, e : T) = e
  };$skip(1342); 
   
  val one = new Succ(Zero);System.out.println("""one  : week4.Natural.Succ = """ + $show(one ));$skip(26); 
  val two = new Succ(one);System.out.println("""two  : week4.Natural.Succ = """ + $show(two ));$skip(28); 
  val three = new Succ(two);System.out.println("""three  : week4.Natural.Succ = """ + $show(three ));$skip(16); val res$0 = 

  three - two;System.out.println("""res0: week4.Natural.Nat = """ + $show(res$0));$skip(13); val res$1 = 
  two + Zero;System.out.println("""res1: week4.Natural.Succ = """ + $show(res$1));$skip(28); val res$2 = 
  two + one - three == Zero;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(12); val res$3 = 
  two + two;System.out.println("""res3: week4.Natural.Succ = """ + $show(res$3));$skip(17); val res$4 = 

  True && True;System.out.println("""res4: week4.Natural.BooleanClass = """ + $show(res$4));$skip(16); val res$5 = 
  True || False;System.out.println("""res5: week4.Natural.BooleanClass = """ + $show(res$5));$skip(16); val res$6 = 
  True && False;System.out.println("""res6: week4.Natural.BooleanClass = """ + $show(res$6));$skip(8); val res$7 = 
  !True;System.out.println("""res7: week4.Natural.BooleanClass = """ + $show(res$7));$skip(9); val res$8 = 
  !False;System.out.println("""res8: week4.Natural.BooleanClass = """ + $show(res$8));$skip(16); val res$9 = 
  True != False;System.out.println("""res9: week4.Natural.BooleanClass = """ + $show(res$9));$skip(15); val res$10 = 
  True < False;System.out.println("""res10: week4.Natural.BooleanClass = """ + $show(res$10));$skip(15); val res$11 = 
  False < True;System.out.println("""res11: week4.Natural.BooleanClass = """ + $show(res$11))}
}