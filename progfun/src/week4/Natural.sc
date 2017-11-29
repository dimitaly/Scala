package week4


object Natural {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }
   
  val one = new Succ(Zero)                        //> one  : week4.Natural.Succ = week4.Natural$$anonfun$main$1$Succ$1@1974028
  val two = new Succ(one)                         //> two  : week4.Natural.Succ = week4.Natural$$anonfun$main$1$Succ$1@f53d61
  val three = new Succ(two)                       //> three  : week4.Natural.Succ = week4.Natural$$anonfun$main$1$Succ$1@90d3c6

  three - two                                     //> res0: week4.Natural.Nat = week4.Natural$$anonfun$main$1$Succ$1@1974028
  two + Zero                                      //> res1: week4.Natural.Succ = week4.Natural$$anonfun$main$1$Succ$1@3f905b
  two + one - three == Zero                       //> res2: Boolean = true
  two + two                                       //> res3: week4.Natural.Succ = week4.Natural$$anonfun$main$1$Succ$1@11e6e7f

  True && True                                    //> res4: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$True$2$@e8
                                                  //| 6c03
  True || False                                   //> res5: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$True$2$@e8
                                                  //| 6c03
  True && False                                   //> res6: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$False$2$@1
                                                  //| 0b75f2
  !True                                           //> res7: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$True$2$@e8
                                                  //| 6c03
  !False                                          //> res8: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$False$2$@1
                                                  //| 0b75f2
  True != False                                   //> res9: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$False$2$@1
                                                  //| 0b75f2
  True < False                                    //> res10: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$False$2$@
                                                  //| 10b75f2
  False < True                                    //> res11: week4.Natural.BooleanClass = week4.Natural$$anonfun$main$1$True$2$@e
                                                  //| 86c03
}