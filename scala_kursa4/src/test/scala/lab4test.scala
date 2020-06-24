import lab4.Typeclasses
import org.scalatest.FunSuite

class lab4test extends FunSuite {

  test("Typeclasses.scala ReversableString") {
    val string = "Stronger"
    val result = "regnortS"
    val reversableString = Typeclasses.testReversableString(string)
    assert(reversableString == result)
  }
  test("Typeclasses.scala SmashInt") {
    val a = 11
    val b = 30
    val result = 41
    val smashInt = Typeclasses.testSmashInt(a, b)
    assert(smashInt == result)
  }
  test("Typeclasses.scala SmashDouble") {
    val a = 2.5
    val b = 3.1
    val result = 7.75
    val smashDouble = Typeclasses.testSmashDouble(a, b)
    assert(smashDouble == result)
  }
  test("Typeclasses.scala SmashString") {
    val a = "Stronger"
    val b = " is Andrey`s nickname"
    val result = "Stronger is Andrey`s nickname"
    val smashString = Typeclasses.testSmashString(a, b)
    assert(smashString == result)
  }
}