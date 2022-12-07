package de.htwg.se.othello
import de.htwg.se.othello.model.{PlayerStrat, PlayerQueue}
import de.htwg.se.othello.model.{MoveCoordinates, Stone}

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalactic.Prettifier.default

class PlayerstateSpec extends AnyWordSpec with Matchers {
  val playerQ = PlayerQueue()
  val pState = PlayerStrat(playerQ)
  pState.stratPlayer1(MoveCoordinates(Stone.B, 1, 1)).success.value should be(
    true
  )
  pState
    .stratPlayer1(MoveCoordinates(Stone.W, 1, 1))
    .isFailure should be(true)

  pState.stratPlayer2(MoveCoordinates(Stone.W, 1, 1)).success.value should be(
    true
  )
  pState
    .stratPlayer2(MoveCoordinates(Stone.B, 1, 1))
    .isFailure should be(true)

  pState.strategy(MoveCoordinates(Stone.B, 1, 1)).success.value should be(
    true
  )
  playerQ.currentState.getStone() should be(Stone.B)
  playerQ.changeState();
  pState.strategy(MoveCoordinates(Stone.W, 1, 1)).success.value should be(
    true
  )
  playerQ.currentState.getStone() should be(Stone.W)
}
