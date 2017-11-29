package week3

object intsets {
  println("Welcome to the Scala worksheet")
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 4
  val t3 = new NonEmpty(5, Empty, Empty)
  println(t2 union t3)
}
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

/**
 * Lets implement a binary tree set structure based on IntSet
 */
/**
 * There only ever needs to be one instance of an empty set.
 * It is simple to declare a singleton class in Scala, by using the
 * keyword "object" in the definition instead of "class"
 */

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet) = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  def union(other: IntSet) = ((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}"
}
 