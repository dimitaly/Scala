package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.8/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = union(union(s1,s2),s3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test ("intersection contains common elements") {
    new TestSets {
      val intersectSet = intersect(s1, s4)

      println("intersectSet");
      printSet(intersectSet); 
      assert(contains(intersectSet,1))
      assert(!contains(intersectSet,2))
      assert(!contains(intersectSet,3))
    }
  }
  
  test("diff gives elements that are only in the first set")
  {
    new TestSets {
    val firstSet = s4
    val secondSet = s1
    val testSet = diff(firstSet, secondSet)
    
    println("diffSet");
      printSet(testSet);
    assert(contains(testSet,2))
    assert(contains(testSet,3))
    assert(!contains(testSet,1))
    }
  }  
  
  test("filter gives us only elements that satisfy the filter function")
  {
    new TestSets
    {
      val filterSet = filter(s4, x => x >= 2 && x <= 3)
      
      println("filterSet");
      printSet(filterSet);
      assert(contains(filterSet,2))
    assert(contains(filterSet,3))
    assert(!contains(filterSet,1))
    }
  }
  
    test("forall returns true if all elements satisfy filter")
  {
    new TestSets
    {
      val filter1 =  (x: Int) => x >= 2 && x <= 3 
      val filter2 =  (x: Int) => x >= 0 && x <= 3 
      
      assert(!forall(s4,filter1))
       assert(forall(s4,filter2))
    }
  }

  test("exists returns true if at least one element satisfies filter") {
      new TestSets
      {
        val filter1 =  (x: Int) => x >= 2 && x < 3 
       val filter2 =  (x: Int) => x == 0
       
       assert(exists(s4, filter1))
       assert(!exists(s4, filter2))
      }
    }
    
    test("Map produces new set containing mapped values")
    {
      new TestSets
      {
        val mapping = (x:Int) => x * x
        val mappedSet =  map(s4, mapping)
        
        printSet(s4)
        println(" maps to ")
        printSet(mappedSet)
       
        assert(contains(mappedSet,1))
        assert(contains(mappedSet,4))
        assert(contains(mappedSet,9))
        assert(!contains(mappedSet, 25))
        
      }
    }
     
  		
}
