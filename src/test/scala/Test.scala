// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class OthelloSpec extends AnyWordSpec {
  "Othello" should {
    "have a bar as String of form '+---+---+---+---+---+'" in {
      bar() should be("+---+---+---+---+---+" + eol)
    }
    "have a cells as String of form '|   |   |   |   |   »'" in {
      cells() should be ("|   |   |   |   |   |" + eol)
    }
    "have mesh as String of form '+---+\n|   |\n+---+'" in {
      mesh() should be("+---+" + eol + "|   |" + eol + "+---+" + eol)
    }
    "have scalable bar" in {
      bar(1,1) should be("+-+" + eol)
      bar(2,1) should be("+--+" + eol)
      bar(1,2) should be("+-+-+" + eol)
    }
    "have scalabe cells" in {
      cells(1,1) should be("| |" + eol)
      cells(2,1) should be("|  |" + eol)
      cells(1,2) should be("| | |" + eol)
    }
  }  
}

