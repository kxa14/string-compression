package com.educationFirst

object Main extends App {
  {
    if (
      s"${args.mkString("").stripMargin}".nonEmpty && s"${args.mkString("").stripMargin}"
        .matches("""[a-z][1-9]+""")
    ) {
      new Parser()
        .compress(s"${args.mkString("").stripMargin}")
      System.exit(0)
    } else if (s"${args.mkString("").stripMargin}".isEmpty) {
      println("Missing an input. Please try again.")
      System.exit(1)
    } else {
      {
        println(s"${args.mkString("")} is an invalid input")
        System.exit(128)

      }
    }
  }
}
