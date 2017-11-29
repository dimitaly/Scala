package week6

import scala.io.Source

object x {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(189); 
  val mnem = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""mnem  : scala.collection.immutable.Map[Char,String] = """ + $show(mnem ));$skip(180); 

  /** Invert the mnem map to give a map from chars 'A' ... 'Z' to '2' ... '9' */
  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; ltr <- str) yield (ltr -> digit);System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(156); 

  /** Maps a word to the digit string it can represent, e.g. "Java" -> "5282" */
  def wordCode(word: String): String =
    word.toUpperCase.map(charCode);System.out.println("""wordCode: (word: String)String""");$skip(26); val res$0 = 

  wordCode("scalaisfun")

  object H {
    val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt").getLines
    val words = in.toList filter (_ forall (_.isLetter))
    val wordsForNum: Map[String, Seq[String]] =
      words groupBy wordCode withDefaultValue List()
  }
  import H._;System.out.println("""res0: String = """ + $show(res$0));$skip(968); 

  /**
   * A map from digit strings to the words that represent them,
   * e,g. "5282" -> List("Java", "Kata", "Lava", ...)
   * Note: A missing number should map to the empty set, e.g. "1111" -> List()
   */
  //val wordsForNum: Map[String, Seq[String]] =
  //  words groupBy wordCode withDefaultValue List()

  /** Return all ways to encode a number as a list of words */
  def encode(number: String): Set[List[String]] = {
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        first <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield first :: rest
    }.toSet
  };System.out.println("""encode: (number: String)Set[List[String]]""");$skip(24); val res$1 = 

  encode("7225247386");System.out.println("""res1: Set[List[String]] = """ + $show(res$1))}
}
