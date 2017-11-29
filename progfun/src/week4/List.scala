package week4

/**
 * generic list trait. This will be implemented using a con-list.
 * A con-list consists of 2 implementations: An empty List, Nil, and a non-empty list cons, 
 * which contains the head element of the list and a reference to the rest of the list.
 */
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  //variance-correct implementaion of prepend
  def prepend[U >: T](elem : U) : List[U] = new Cons(elem, this)
}

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
  }

  /**
   * It is valid head and tail  to explicitly return type Nothing because
   * nothing is the subtype of all classes, which makes it also the subtype of any T
   * This isn't necessary and is shown for demonstrative purposes.
   */
  object Nil extends List[Nothing] {
    def isEmpty = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }
/*
   * Nil can be assigned to x because List is covariant in its type parameter T 
   * and Nothing is the subtype of all classes, so by impplication, Nil is a subtype of any 
   * parameterised list.
   */
object test {
  val x: List[String] = Nil

}

