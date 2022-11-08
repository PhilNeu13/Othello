package de.htwg.se.othello

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import de.htwg.se.othello.model.Matrix
import de.htwg.se.othello.model.Player
import de.htwg.se.othello.model.Stone

class PlayerSpec extends AnyWordSpec {
  "A Player" should {
    val player = Player(name = "Lukas", stone = Stone.B)
    "have a name" in {
      player.name should be("Lukas")
    }
    "have initialy zero points" in {
      player.points should be(0)
    }
    "have a stone" in {
      player.stone should be(Stone.B)
    }

  }

}
