package de.htwg.se.othello

import de.htwg.se.othello.model.Stone
import de.htwg.se.othello.model.Player
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.scalatest.matchers.must.Matchers

class PlayerSpec extends AnyWordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Phil", Stone.B)
      "have a name" in {
        player.name should be("Phil")
      }
      "have a stone" in {
        player.stone should be(Stone.B)
      }
      "have a nice String representation" in {
        player.toString should be("Phil has Stone B")
      }
    }
  }
}
