package de.htwg.se.othello
package aview

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import de.htwg.se.othello.model.{Field, Stone, MoveCoordinates, Player}

import de.htwg.se.othello.controller.Controller
import de.htwg.se.othello.util.PlayerQueue

class TUISpec extends AnyWordSpec {
  "The TUI" should {

    val phil = new Player("Phil", Stone.B)
    val lukas = new Player("Lukas", Stone.W)
    val playerQ = new PlayerQueue
    val tui = TUI(Controller(new Field(6, Stone.Empty), playerQ), playerQ)
    "recognize the input x12 as move of stone x to field (1,2)" in {
      tui.makeAMove("B12") should be(Some(MoveCoordinates(Stone.B, 1, 2)))
    }
  }
}
