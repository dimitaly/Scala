package week6

import scala.io.Source

object phoneDictionary {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(163); 
val in = Source.fromFile("C:/Users/Dima/Documents/scala course/progfun/src/week6/linuxwords.txt");System.out.println("""in  : scala.io.BufferedSource = """ + $show(in ));$skip(86); 
  val words = in.getLines.toList filter (word => word forall (char => char.isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(140); 
  val mnem = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""mnem  : scala.collection.immutable.Map[Char,String] = """ + $show(mnem ));$skip(179); 

  /** Invert the mnem map to give a map from chars 'A' ... 'Z' to '2' ... '9' */
  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit;System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(282); 

  /**
   * Maps a word to the digit string it can represent, e.g. "Java" -> "5282".
   * Remember maps are functions too, so passing in charCode as an argument to the map function on a String is allowed.
   */
  def wordCode(word: String): String = word.toUpperCase.map(charCode);System.out.println("""wordCode: (word: String)String""");$skip(25); val res$0 = 
  wordCode("scalaisfun");System.out.println("""res0: String = """ + $show(res$0));$skip(304); 

  /**
   * A map from digit strings to the words that represent them,
   * e,g. "5282" -> List("Java", "Kata", "Lava", ...)
   * Note: A missing number should map to the empty set, e.g. "1111" -> List()
   */
  val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue List();System.out.println("""wordsForNum  : Map[String,Seq[String]] = """ + $show(wordsForNum ));$skip(336); 
  /** Return all ways to encode a number as a list of words */
  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet;System.out.println("""encode: (number: String)Set[List[String]]""");$skip(25); val res$1 = 

  encode("7225247386");System.out.println("""res1: Set[List[String]] = """ + $show(res$1));$skip(89); 

  def translate(number: String): Set[String] =
    encode(number) map (_ mkString " ");System.out.println("""translate: (number: String)Set[String]""");$skip(28); val res$2 = 

  translate("7225247386");System.out.println("""res2: Set[String] = """ + $show(res$2));$skip(25); val res$3 = 
  translate("225247386");System.out.println("""res3: Set[String] = """ + $show(res$3))}
}
