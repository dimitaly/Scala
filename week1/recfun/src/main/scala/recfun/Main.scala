package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println(balance("())(".toList))
    println(countChange(4, List(3)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    {
      if (c > r || r < 0 || c < 0) throw new NoSuchElementException()
      if (r == c || c == 0) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    {
      def isBalanced (numOfUnbalancedOpenBrackets: Int, list: List[Char]): Boolean =
      {
        if(numOfUnbalancedOpenBrackets < 0) false
        else if (list.isEmpty) numOfUnbalancedOpenBrackets == 0 
          else if(list.head == '(') isBalanced(numOfUnbalancedOpenBrackets+1, list.tail)
          else if(list.head == ')') isBalanced(numOfUnbalancedOpenBrackets - 1, list.tail)
          else isBalanced(numOfUnbalancedOpenBrackets, list.tail)
        }

      isBalanced(0, chars)
    }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = 
  {
    if(money < 0)  0 else
      if(money == 0) 1 else
        if(money> 0 && coins.isEmpty) 0 else
          if(coins.head <= 0) throw new IllegalArgumentException("coins must not contain non-positive denominations") 
          else countChange(money-coins.head, coins) + countChange(money, coins.tail)
  }

}
