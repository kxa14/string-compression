package com.educationFirst

import scala.util.matching.Regex

class Parser {
  private final val pattern: Regex = """[a-z][1-9]+""".r
  def compress(input: String): String = {
    val parsedResult: Map[Char, Int] =
      pattern.findAllIn(input).foldLeft(Map.empty[Char, Int]) {
        case (acc, nextMatch) =>
          val newOcc = nextMatch.tail.toInt
          acc.get(nextMatch.head) match {
            case Some(existingOcc) =>
              acc + (nextMatch.head -> (newOcc + existingOcc))
            case None => acc + (nextMatch.head -> newOcc)
          }
      }

    parsedResult.toList.sortBy { case (k, _) => k }.foldLeft("") {
      case (res, (k, v)) => s"$res$k$v"
    }
  }
}