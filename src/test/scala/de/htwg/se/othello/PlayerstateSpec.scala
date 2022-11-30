package de.htwg.se.othello
import de.htwg.se.othello.util.{PlayerState, PlayerQueue}
import de.htwg.se.othello.model.{MoveCoordinates, Stone}

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class PlayerstateSpec {
  val pState = PlayerState
  pState.stratPlayer1(MoveCoordinates(Stone.B, 1, 1)) should be(true)
  pState.stratPlayer2(MoveCoordinates(Stone.W, 1, 1)) should be(true)
}
