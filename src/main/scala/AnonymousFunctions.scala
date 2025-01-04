package mbds.it.fp

import scala.language.postfixOps

object AnonymousFunctions extends App {
  //Instead of writing a new instance of the class Function
  // we can only declare the function in the following way:

  //Anonymous Function or Lambda
  val doubler2: Int => Int = x => x * 2

  //syntax rules for multiple parameters
  val adder1 = (a: Int, b: Int) => a + b
  val adder2: (Int, Int) => Int = (a, b) => a + b

  //No parameters
  val justDoSomething: () => Int = () =>3
  println(justDoSomething)
  //lambdas must be called with parenthesis
  println(justDoSomething())

  //curly braces with lambdas

  //This is a common style of writing lambdas
  val stringToInt = { (str:String) =>
    str.toInt
  }

  //MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x+1
  val niceAdder: (Int,Int) => Int = _ + _ //(a,b) => a+b

  /*
  *Exercises
  * 1. Rewrite the curried special writer as an anonymous functions
  *
  */

  val superAdder: (Int,Int) => Int = (a,b) => a+b
  
  println(superAdder(4,5))
}


