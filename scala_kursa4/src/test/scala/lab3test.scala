import lab3.{Adts, Maps, Sequence, Strings}
import org.scalatest.FunSuite
import scala.util.{Failure, Success, Try}

class lab3test extends FunSuite {

  test("String.scala testUppercase") {
    assert(Strings.testUppercase("Hello") == "HELLO")
  }
  test("String.scala testInterpolations") {
    val testInterpolations = Strings.testInterpolations("Andrey", 19)
    val result = "Hi, my name is Andrey and I am 19 years old."
    assert(testInterpolations == result)
  }
  test("String.scala testComputation") {
    val testComputation = Strings.testComputation(100, 200)
    val result = "Hi,\n now follows a quite hard calculation. We try to add: \na := 100\nb := 200\n\nresult is 300"
    assert(testComputation == result)
  }
  test("String.scala testTakeTwo") {
    val testTakeTwo = Strings.testTakeTwo("qwerty")
    val result = "qw"
    assert(testTakeTwo == result)
  }


  test("Sequence.scala testLastElement") {
    val seq = Seq[Int](1, 2, 3)
    val testLastElement = Sequence.testLastElement(seq)
    val result = Option[Int](3)
    assert(testLastElement == result)
  }
  test("Sequence.scala testZip") {
    val testZip = Sequence.testZip(Seq[Int](1, 2), Seq[Int](3, 4))
    val result = Seq((1, 3), (2, 4))
    assert(testZip == result)
  }
  test("Sequence.scala testForAll") {
    val cond: Int => Boolean = _ % 2 == 0
    val testForAll = Sequence.testForAll(Seq(1, 2))(cond)
    val result = false
    assert(testForAll == result)
  }
  test("Sequence.scala testPalindrom") {
    val testPalindrom = Sequence.testPalindrome(Seq(2, 5, 5, 2))
    val result = true
    assert(testPalindrom == result)
  }
  test("Sequence.scala testFlatMap") {
    val seq = Seq(1,(5, 2),3,4)
    val func = (value: Any) => Seq(Seq(value))
    val testFlatMap = Sequence.testFlatMap(seq)(func)
    val result = Seq(Seq(1), Seq((5, 2)), Seq(3), Seq(4))
    assert(testFlatMap == result)
  }


  test("Maps.scala testGroupUsers") {
    val users = Seq(Maps.User("Andrey", 19), Maps.User("Darya", 18), Maps.User("Max", 24))
    val testGroupUsers = Maps.testGroupUsers(users)
    val result = Map("Andrey" -> 19, "Darya" -> 18, "Max" -> 24)
    assert(testGroupUsers == result)
  }
  test("Maps.scala testNumberFrodos") {
    val users = Map("1" -> Maps.User("Adam", 20),
      "2" -> Maps.User("Andrey", 19), "3" -> Maps.User("Madam", 18))
    val testNumberFrodos = Maps.testNumberFrodos(users)
    val result = 1
    assert(testNumberFrodos == result)
  }
  test("Maps.scala testUnderaged") {
    val users = Map("1" -> Maps.User("Max", 38),
      "2" -> Maps.User("Andrey", 19), "3" -> Maps.User("Darya", 41))
    val testUnderaged = Maps.testUnderaged(users)
    val result = Map("1" -> Maps.User("Max", 38),
      "3" -> Maps.User("Darya", 41))
    assert(testUnderaged == result)
  }


  test("Adts.scala testGetNth") {
    val testGetNth = Adts.testGetNth(List(1, 2, 3, 4), 2)
    val result = Option(3)
    assert(testGetNth == result)

    val testGetNth2 = Adts.testGetNth(Nil, 2)
    val result2 = null
    assert(testGetNth2 == result2)
  }
  test("Adts.scala testDouble") {
    val testDouble = Adts.testDouble(Option(5))
    val result = Option(10)
    assert(testDouble == result)

    val testDouble2 = Adts.testDouble(None)
    val result2 = null
    assert(testDouble2 == result2)
  }
  test("Adts.scala testIsEven") {
    val testIsEven = Adts.testIsEven(5)
    val result = Left("Not even")
    assert(testIsEven == result)
  }
  test("Adts.scala testSafeDivide") {
    val testSafeDivide = Adts.testSafeDivide(10, 2)
    val result = Right(5)
    assert(testSafeDivide == result)

    val testSafeDivide2 = Adts.testSafeDivide(9, 0)
    val result2 = Left("You can't divide by zero")
    assert(testSafeDivide2 == result2)
  }
  test("Adts.scala testGoodOldJava") {
    val string = "test"
    val func = (s:String) => s.length
    val result = Success(4)
    val goodOldJava = Adts.testGoodOldJava(func, string)
    assert(goodOldJava == result)
  }
}