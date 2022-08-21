package com.educationFirst

object Main extends App {
  {
    if (s"${args.mkString("").stripMargin}".isEmpty) {
      println("Missing an input. Please try again.")
    } else
      println(new Parser().compress(s"${args.mkString("").stripMargin}"))
  }
}
