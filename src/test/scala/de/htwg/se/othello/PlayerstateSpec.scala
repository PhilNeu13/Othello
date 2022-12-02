package de.htwg.se.othello
import de.htwg.se.othello.model.{PlayerState, PlayerQueue}
import de.htwg.se.othello.model.{MoveCoordinates, Stone}

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers

class PlayerstateSpec extends AnyWordSpec with Matchers {
  val playerQ = PlayerQueue()
  val pState = PlayerState(playerQ)
  pState.stratPlayer1(MoveCoordinates(Stone.B, 1, 1)) should be(true)
  pState.stratPlayer1(MoveCoordinates(Stone.W, 1, 1)) should be(false)
  pState.stratPlayer2(MoveCoordinates(Stone.W, 1, 1)) should be(true)
  pState.stratPlayer2(MoveCoordinates(Stone.B, 1, 1)) should be(false)

  pState.strategy(MoveCoordinates(Stone.B, 1, 1)) should be(true)
  playerQ.changeState();
  pState.strategy(MoveCoordinates(Stone.W, 1, 1)) should be(true)

}
