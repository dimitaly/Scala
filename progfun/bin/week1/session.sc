package week1

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  1+2                                             //> res0: Int(3) = 3


  def sqrt(x: Double) = {
    
    def abs(x: Double) =
      if (x >= 0) x else -x
    
    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x <= 0.0001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(0.001)                                     //> res1: Double = 0.03162278245070105
  sqrt(0.1e-20)                                   //> res2: Double = 3.1622778383672726E-11
  sqrt(1.0e20)                                    //> res3: Double = 1.0000021484861237E10
  sqrt(1.0e50)                                    //> res4: Double = 1.0000003807575104E25
  
}