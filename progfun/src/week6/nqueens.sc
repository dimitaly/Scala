package week6

object nqueens {
  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List()) else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens

    placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]
  /**
   * function to check if it is safe to put queen in
   * column col on an additional row w.r.t the postion of the queens
   * on the other rows *
   */
  def isSafe(col: Integer, queens: List[Int]): Boolean =
    {
      val row = queens.length
      val queensWithRow = queens zip (row - 1 to 0 by -1)
      queensWithRow forall {
        case (c, r) => c != col && Math.abs(col - c) != row - r
      }
    }                                             //> isSafe: (col: Integer, queens: List[Int])Boolean

  isSafe(2, List())                               //> res0: Boolean = true

  val fourQueens = queens(4)                      //> fourQueens  : Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))

  def show(queens: List[Int]) = {
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
  }                                               //> show: (queens: List[Int])String

  /**
   * mkString is a utility function that formats a collection to a string.
   * By default the delimiter fot each string representation is a comma, but this can be
   * changed via an optional second parameter. Here he use a newline to demarcate the chessboards
   */
  (fourQueens map show) mkString "\n"             //> res1: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "
  val eightQueens = queens(8)                     //> eightQueens  : Set[List[Int]] = Set(List(2, 0, 6, 4, 7, 1, 3, 5), List(5, 2
                                                  //| , 0, 7, 3, 1, 6, 4), List(4, 1, 7, 0, 3, 6, 2, 5), List(4, 2, 7, 3, 6, 0, 5
                                                  //| , 1), List(4, 2, 0, 5, 7, 1, 3, 6), List(2, 6, 1, 7, 4, 0, 3, 5), List(3, 5
                                                  //| , 7, 1, 6, 0, 2, 4), List(2, 5, 1, 6, 4, 0, 7, 3), List(4, 0, 7, 3, 1, 6, 2
                                                  //| , 5), List(3, 5, 7, 2, 0, 6, 4, 1), List(6, 3, 1, 7, 5, 0, 2, 4), List(5, 2
                                                  //| , 6, 1, 7, 4, 0, 3), List(3, 7, 0, 2, 5, 1, 6, 4), List(2, 5, 3, 1, 7, 4, 6
                                                  //| , 0), List(3, 1, 6, 2, 5, 7, 0, 4), List(7, 2, 0, 5, 1, 4, 6, 3), List(0, 6
                                                  //| , 3, 5, 7, 1, 4, 2), List(1, 7, 5, 0, 2, 4, 6, 3), List(1, 5, 0, 6, 3, 7, 2
                                                  //| , 4), List(3, 7, 0, 4, 6, 1, 5, 2), List(3, 7, 4, 2, 0, 6, 1, 5), List(5, 2
                                                  //| , 4, 7, 0, 3, 1, 6), List(7, 3, 0, 2, 5, 1, 6, 4), List(5, 2, 6, 3, 0, 7, 1
                                                  //| , 4), List(2, 4, 1, 7, 5, 3, 6, 0), List(0, 5, 7, 2, 6, 3, 1, 4), List(3, 1
                                                  //| , 6, 4, 0, 7, 5, 2), List(6, 2, 0, 5, 7, 4, 1, 3), List(6, 3, 1, 4, 7, 0, 2
                                                  //| , 5), List(4, 0, 3, 5, 
                                                  //| Output exceeds cutoff limit.
  
  eightQueens.size                                //> res2: Int = 92
  
   (queens(8) take(3) map show) mkString "\n"     //> res3: String = "
                                                  //| * * * * * X * * 
                                                  //| * * * X * * * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * X * * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * * X * * * "
}