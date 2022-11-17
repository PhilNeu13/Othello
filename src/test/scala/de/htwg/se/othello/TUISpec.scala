package de.htwg.se.othello
package aview

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.othello.model.{Field, Stone, MoveCoordinates}
import de.htwg.se.othello.controller.Controller

class TUISpec extends AnyWordSpec {
  "The TUI" should {
    val tui = TUI(Controller(new Field(6, Stone.Empty)))
    "recognize the input x12 as move of stone x to field (1,2)" in {
      tui.makeAMove("B12") should be(Some(MoveCoordinates(Stone.B, 0, 1)))
    }
  }
}
