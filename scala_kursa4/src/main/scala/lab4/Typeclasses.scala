package lab4

object Typeclasses extends App {

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.

  trait Reversable[T] {
    def reverse(x: T): T
  }

  object Reversable {
    implicit object ReversableString extends Reversable[String] {
     def reverse(x: String): String = x.reverse
    }
  }

  // b) Реализуйте функцию Reverse для String.

  def reverse[T](str: T)(implicit rev: Reversable[T]): T = rev.reverse(str)

  // примените тайп-класс-решение из пункта (a) здесь

  def testReversableString(str: String): String = reverse(str)
  println(testReversableString("Stronger"))

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.
  trait Smash[T] {
    def smash(a: T, b: T): T
  }

  object Smash {
    implicit object SmashInt extends Smash[Int] {
      def smash(a: Int, b: Int): Int = a+b
    }
    implicit object SmashDouble extends Smash[Double] {
      def smash(a: Double, b: Double): Double = a*b
    }
    implicit object SmashString extends Smash[String] {
      def smash(a: String, b: String): String = a.concat(b)
    }
  }

  // d) Реализуйте  функции Smash для типа Int и Double.
  //    Используйте сложение для типа Int у умножение для типа Double.

def smash[T](a: T, b: T)(implicit sma: Smash[T]): T = sma.smash(a,b)

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = smash(a,b)

  println(testSmashInt(11,30))

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = smash(a,b)

  println(testSmashDouble(3.33333, 5.16666))

  // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра. 


  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashString(a: String, b: String): String = smash(a,b)

  println(testSmashString("Stronger", " is Andrey`s nickname"))
}
