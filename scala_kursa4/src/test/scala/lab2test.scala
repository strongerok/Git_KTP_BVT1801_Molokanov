import lab2.{Compositions, Cons, RecursiveData, RecursiveFunctions}
import org.scalatest.FunSuite

class lab2test extends FunSuite {
  // RecursiveData.scala
  test("RecursiveData.scala testListIntEmpty") {
    val list = Nil[Int]()
    val testListIntEmpty = RecursiveData.testListIntEmpty(list)
    assert(testListIntEmpty)
  }
  test("RecursiveData.scala testListIntHead") {
    val listNil = Nil[Int]()
    val listCons = Cons[Int](2, listNil)
    val testListIntHead = RecursiveData.testListIntHead(listNil)
    assert(testListIntHead == -1)
    val testListIntHead2 = RecursiveData.testListIntHead(listCons)
    assert(testListIntHead2 == 2)
  }


  // RecursiveFunc.scala
  test("RecursiveFunc.scala testReverse") {
    val listPre = Cons[Int](2, Cons[Int](1, Nil[Int]()))
    val listPost = Cons[Int](1, Cons[Int](2, Nil[Int]()))
    val testReverse = RecursiveFunctions.testReverse(listPre)
    assert(testReverse == listPost)
  }
  test("RecursiveFunc.scala testMap") {
    val listPre = Cons[Int](2, Cons[Int](4, Nil[Int]()))
    val anonFunc = (a: Int) => a * 2
    val testMap = RecursiveFunctions.testMap(listPre, anonFunc)

    val listResult = Cons[Int](4, Cons[Int](8, Nil[Int]()))
    assert(testMap == listResult)
  }
  test("RecursiveFunc.scala testAppend") {
    val listPre = Cons[Int](2, Cons[Int](4, Nil[Int]()))
    val listPost = Cons[Int](3, Cons[Int](1, Nil[Int]()))
    val testAppend = RecursiveFunctions.testAppend(listPre, listPost)

    val listResult = Cons[Int](2, Cons[Int](4, listPost))
    assert(testAppend == listResult)
  }
  test("RecursiveFunc.scala testFlatMap") {
    val func: List[Int] => List[Int] = {
      case Cons(head, tail) => Cons(head, tail)
      case Nil() => Nil()
    }
    val list = Cons[Cons[Int]](Cons[Int](1 , Nil[Int]()), Cons[Cons[Int]](Cons[Int](2 , Nil[Int]()), Nil[Cons[Int]]()))
    val list1 = Cons[Int](1 , Cons[Int](2 , Nil[Int]()))
    val testFlatMap = RecursiveFunctions.testFlatMap(list, func)
    assert(testFlatMap == list1)
  }

  // Compositions.scala
  test("Compositions.scala testCompose") {
    def f(a: Int) = a + 2
    def g(a: Int) = a + 3
    def h(a: Int) = a + 4
    def result (a: Int) = a + 2 + 3 + 4
    val testCompose = Compositions.testCompose(f)(g)(h)
    assert(testCompose(2) == result(2))
  }
  test("Compositions.scala testMapFlatMap") {
    val f = (value:Int) => Some[Int](value + 1)
    val g = (value:Int) => Some[Int](value - 2)
    val h = (value: Int) => value - 13
    val res = Some[Int](-12)
    val testMapFlatMap = Compositions.testMapFlatMap(f)(g)(h)
    assert(testMapFlatMap(Some[Int](2)) == res)
  }
  test("Compositions.scala testForComprehension") {
    val f = (value:Int) => Some[Int](value + 1)
    val g = (value:Int) => Some[Int](value - 2)
    val h = (value: Int) => value - 13
    val res = Some[Int](-12)
    val testForComprehension = Compositions.testForComprehension(f)(g)(h)
    assert(testForComprehension(Some[Int](2)) == res)
  }
}