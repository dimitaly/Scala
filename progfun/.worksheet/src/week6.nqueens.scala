package week6

object nqueens {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(322); 
  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List()) else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens

    placeQueens(n)
  };System.out.println("""queens: (n: Int)Set[List[Int]]""");$skip(417); 
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
    };System.out.println("""isSafe: (col: Integer, queens: List[Int])Boolean""");$skip(21); val res$0 = 

  isSafe(2, List());System.out.println("""res0: Boolean = """ + $show(res$0));$skip(31); 

  val fourQueens = queens(4);System.out.println("""fourQueens  : Set[List[Int]] = """ + $show(fourQueens ));$skip(198); 

  def show(queens: List[Int]) = {
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
  };System.out.println("""show: (queens: List[Int])String""");$skip(314); val res$1 = 

  /**
   * mkString is a utility function that formats a collection to a string.
   * By default the delimiter fot each string representation is a comma, but this can be
   * changed via an optional second parameter. Here he use a newline to demarcate the chessboards
   */
  (fourQueens map show) mkString "\n";System.out.println("""res1: String = """ + $show(res$1));$skip(30); 
  val eightQueens = queens(8);System.out.println("""eightQueens  : Set[List[Int]] = """ + $show(eightQueens ));$skip(22); val res$2 = 
  
  eightQueens.size;System.out.println("""res2: Int = """ + $show(res$2));$skip(49); val res$3 = 
  
   (queens(8) take(3) map show) mkString "\n";System.out.println("""res3: String = """ + $show(res$3))}
}
