package week4

object expressions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Var(x) => x
    case Sum(l, r) => show(l) + " + " + show(r)
    case Prod(Sum(e1, e2), Sum(e3, e4)) => "(" + show(Sum(e1, e2)) + ")" + " * (" + show(Sum(e3, e4)) + ")"
    case Prod(Sum(e1, e2), e3) => "(" + show(Sum(e1, e2)) + ") * " + show(e3)
    case Prod(e1, Sum(e2, e3)) => show(e1) + " * (" + show(Sum(e2, e3)) + ")"
    case Prod(l, r) => show(l) + " * " + show(r)
  }                                               //> show: (e: week4.Expr)String

  show(Sum(Number(1), Number(44)))                //> res0: String = 1 + 44
  show(Sum(Var("x"), Var("y")))                   //> res1: String = x + y
  show(Prod(Sum(Number(1), Number(44)), Number(5)))
                                                  //> res2: String = (1 + 44) * 5
  show(Prod(Number(5), Sum(Var("x"), Var("y"))))  //> res3: String = 5 * (x + y)
  show(Prod(Sum(Number(1), Number(44)), Sum(Var("x"), Var("y"))))
                                                  //> res4: String = (1 + 44) * (x + y)
}