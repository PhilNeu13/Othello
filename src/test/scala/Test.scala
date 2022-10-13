// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class OthelloSpec extends AnyWordSpec:
  "Othello" should {
    "have a bar as String of form '+---+---+---+---+---+'" in {
      bar() should be("+---+---+---+---+---+" + eol)
    }
  }  


