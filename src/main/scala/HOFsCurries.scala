package mbds.it.fp

import scala.annotation.tailrec

object HOFsCurries extends App {

  //Higher order function - receive or return another function
//val superFunction: (Int,(String,(Int =>Boolean)) => Int)=> (Int =>Int) = ???

  //Examples of HOF: map, flatmap, filter

  //In functional programming we would like to think and use HOF's

  //function that applies n times over a value x
  //nTimes(f - function, n - number of times, x - subject of the app)
  //nTimes(f,n,x) = f(f(f(x))) = f(nTimes(f,n-1,x))

  @tailrec
  def nTimes(f:Int => Int, n:Int, x:Int): Int = {
    if (n<=0) x
    else nTimes(f,n-1,f(x))
  }

  val plusOne = (x:Int) => x+1
  //FP becomes the direct application of math in programming.

  println(nTimes(plusOne,4,2)) //should return 6


  // There is a better way to implement this.
  // We can implement a function that takes a random function and apply it n times.
  // After that we can just apply this is any number.

  def nTimesBetter (f:Int => Int,n: Int):(Int => Int) = {
    if (n<=0) (x:Int) => x
    else (x:Int) => nTimesBetter(f,n-1)(f(x))
  }
  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(3))


  //curried functions
  val superAdder: Int => (Int => Int) = (x:Int) => (y:Int) => x+y
  val add4 = superAdder(4) //y=> 3+y
  println(add4(10))
  println(superAdder(4)(10))

  // Those helper functions are very useful when you want to apply
  // those functions later on, on various values.

  //Functions with multiple parameter lists
  def curriedFormatter(c:String)(d: Double): String = c.format(d)
  val standardFormat: (Double => String) =curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) =curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
  * */
}
