package de.htwg.se.othello
package aview

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import de.htwg.se.othello.model._
import de.htwg.se.othello.model.fieldComponent.Field
import de.htwg.se.othello.model.MoveCoordinates
import de.htwg.se.othello.model.{Player, PlayerQueue}
import de.htwg.se.othello.controller.controllerComponent.Controller
import de.htwg.se.othello.model._

class TUISpec extends AnyWordSpec {
  "The TUI" should {

    val phil = new Player("Phil", Stone.B)
    val lukas = new Player("Lukas", Stone.W)
    val playerQ = new PlayerQueue
    val tui = TUI(Controller(new Field(6, Stone.Empty), playerQ), playerQ)

    "recognize the input B12 as move of stone x to field (1,2)" in {
      tui.makeAMove("B12") should be(Some(MoveCoordinates(Stone.B, 1, 2)))
    }
    "recognize the input W11 as move of stone x to field (1,1)" in {
      tui.makeAMove("W11") should be(Some(MoveCoordinates(Stone.W, 1, 1)))
    }
    "recognize the input b as quit" in {
      tui.makeAMove("q") should be(None)
    }
    "recognize the input u as undo" in {
      tui.makeAMove("u") should be(None)
    }
    "recognize the input r as redo" in {
      tui.makeAMove("r") should be(None)
    }
  }
}
import org.scalatest.matchers.must.Matchers
