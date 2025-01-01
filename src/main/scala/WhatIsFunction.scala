package mbds.it.fp

object WhatIsFunction extends App {
/* The whole idea behind FP is to use functions as whole class elements.
* DREAM: use functions as first class elements
* PROBLEM: we come from an OOP world - EVERYTHING IS AN OBJECT OF A CLASS*/

val doubler = new MyFunction[Int,Int] {
    override def apply(element:Int): Int = element*2
}
//can be called like a function
println(doubler(100))

// Scala language supports function types from 1 to 22
//function1[A,B]

val string2IntConverter = new Function1[String,Int] {
  override def apply(v1: String): Int = v1.toInt
}

println(string2IntConverter("812235465")+1)


val adder: ((Int,Int) => Int) = new Function2[Int,Int,Int] {
  override def apply(v1: Int, v2: Int): Int = v1+v2
}
// This is getting close to FP.
//Function types Function2[A,B,R] == (A,B) => R

// ALL SCALA FUNCTIONS ARE OBJECTS - THATS THE ELEPHANT IN THE ROOM

/*
* EXERCISES
* 1. Define a function which takes 2 strings and concatenate them
* 2. Transform MyPredicate and My Transformer in function types
* 3. Define a function which takes an argument Int and returns another function which
* takes an Int and return an Int.
* - what is the type of this function and how to implement*/
//1.

val concater: ((String,String) => String) = new Function2[String,String,String] {
  override def apply(s1:String,s2:String): String = s1+s2
}

println(concater("he","he"))

//3. MY FIRST HOF

//Function1[Int, Function1[Int,Int]]
val superAdder: Function1[Int, Function1[Int,Int]] = new Function1[Int, Function1[Int,Int]] {
override def apply(x:Int): Function1[Int,Int] = new Function1[Int,Int] {
  override def apply (y:Int): Int = x+y
}
}
  val adder3: Function1[Int,Int] = superAdder(3)
  println(adder3(4))

  //This special function is also called a curried function
  println(superAdder(3)(4))

}



trait ActionHalfFunctional[A,B] {
  def execute(element: A): B
}
//This is the goal - because we still depend a bit on OOP somehow
trait MyFunction[A,B] {
  def apply(element: A): B
}