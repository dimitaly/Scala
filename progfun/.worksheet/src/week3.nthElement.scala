package week3

import week4._

object nthElement {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Welcome to the Scala worksheet");$skip(151); 
    def nth[T](n: Int, xs: List[T]): T =
  if(xs.isEmpty) throw new IndexOutOfBoundsException
  else  if (n == 0) xs.head
    else nth(n - 1, xs.tail);System.out.println("""nth: [T](n: Int, xs: week4.List[T])T""");$skip(68); 
 
  val list = new List.cons (1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : <error> = """ + $show(list ));$skip(14); val res$0 = 
 nth(2, list);System.out.println("""res0: <error> = """ + $show(res$0));$skip(15); val res$1 = 
 nth(-1, list);System.out.println("""res1: <error> = """ + $show(res$1));$skip(14); val res$2 = 
 nth(4, list);System.out.println("""res2: <error> = """ + $show(res$2))}
 
}