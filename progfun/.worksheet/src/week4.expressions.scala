package week4

object expressions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet");$skip(461); 

  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Var(x) => x
    case Sum(l, r) => show(l) + " + " + show(r)
    case Prod(Sum(e1, e2), Sum(e3, e4)) => "(" + show(Sum(e1, e2)) + ")" + " * (" + show(Sum(e3, e4)) + ")"
    case Prod(Sum(e1, e2), e3) => "(" + show(Sum(e1, e2)) + ") * " + show(e3)
    case Prod(e1, Sum(e2, e3)) => show(e1) + " * (" + show(Sum(e2, e3)) + ")"
    case Prod(l, r) => show(l) + " * " + show(r)
  };System.out.println("""show: (e: week4.Expr)String""");$skip(37); val res$0 = 

  show(Sum(Number(1), Number(44)));System.out.println("""res0: String = """ + $show(res$0));$skip(32); val res$1 = 
  show(Sum(Var("x"), Var("y")));System.out.println("""res1: String = """ + $show(res$1));$skip(52); val res$2 = 
  show(Prod(Sum(Number(1), Number(44)), Number(5)));System.out.println("""res2: String = """ + $show(res$2));$skip(49); val res$3 = 
  show(Prod(Number(5), Sum(Var("x"), Var("y"))));System.out.println("""res3: String = """ + $show(res$3));$skip(66); val res$4 = 
  show(Prod(Sum(Number(1), Number(44)), Sum(Var("x"), Var("y"))));System.out.println("""res4: String = """ + $show(res$4))}
}