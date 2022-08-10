import org.scalatest.funsuite.AnyFunSuite

class ParserTest extends AnyFunSuite {
  private val parser = new Parser()
  test("parser return original string") {
    assert(parser.compress("a2b3c45d115") == "a2b3c45d115")
  }

  test("parser compresses letter a only and sorts the letter alphabetically.") {
    assert(parser.compress("a2b3a5c56a14") == "a21b3c56")
  }

  test("parser compresses letter a and letter b.") {
    assert(parser.compress("a2a3b4a5b7") == "a10b11")
  }

  test("parser compresses letter d") {
    assert(parser.compress("a1d23c1567d14") == "a1c1567d37")
  }

  test("parser is case sensitive and only accepts lower case") {
    assert(parser.compress("A1B1A12") == "")
  }

  test("parser should return given short string") {
    assert(parser.compress("a1") == "a1")
  }

  test("parser should return an empty string given an empty string") {
    assert(parser.compress("") == "")
  }

  test(
    "parser should return an empty string for anything that does not contain a single letter "
  ) {
    assert(parser.compress("$12") == "")
    assert(parser.compress("12") == "")
  }

  test(
    "parser should ignore non-letter and parses in only valid string which starts with letter"
  ) {
    assert(parser.compress("$a12&b34-a12") == "a24b34")
    assert(parser.compress("$a12&b3-4-a12") == "a24b3")
  }

  test(
    "parser should ignore duplicated letter and only parse a letter followed by a number and ignore the rest."
  ) {
    assert(parser.compress("aa22") == "a22")
  }

  test(
    "parser should ignore digit in that is not adjacent to a letter."
  ) {
    assert(parser.compress("aa2 2 b34") == "a2b34")
  }

  test(
    "parser should return an empty string for whitespace."
  ) {
    assert(parser.compress(" ") == "")
  }
}
