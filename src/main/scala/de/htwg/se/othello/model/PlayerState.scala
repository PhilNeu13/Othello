package de.htwg.se.othello.model

import de.htwg.se.othello.model.MoveCoordinates
import de.htwg.se.othello.model.Stone
import scala.util.{Success, Failure, Try}
import org.scalactic.Bool
import java.lang.invoke.WrongMethodTypeException

class PlayerQueue {
  var black: State = new TurnBlack(this)
  var white: State = new TurnWhite(this)
  var currentState: State = new TurnBlack(this)
  var prevState: State = new TurnWhite(this)

  def changeState(): Unit = currentState.changeState()
}

trait State {
  def changeState(): Unit
}

class TurnBlack(playerQueue: PlayerQueue) extends State {

  def changeState(): Unit =
    playerQueue.prevState = this
    playerQueue.currentState = playerQueue.white

}

class TurnWhite(playerQueue: PlayerQueue) extends State {
  def changeState(): Unit =
    playerQueue.prevState = this
    playerQueue.currentState = playerQueue.black

}
class PlayerStrat(playerQ: PlayerQueue) {
  def strategy(
      move: MoveCoordinates
  ) =
    if (playerQ.currentState.isInstanceOf[TurnBlack])
      stratPlayer1(move)
    else stratPlayer2(move)

  def stratPlayer1(move: MoveCoordinates): Try[Boolean] = {
    move.stone match {
      case Stone.B => Success(true)
      case _       => Failure(new Exception("Wrong Player/Stone"))
    }
  }

  def stratPlayer2(move: MoveCoordinates): Try[Boolean] = {
    move.stone match {
      case Stone.W => Success(true)
      case _       => Failure(new Exception("Wrong Player/Stone"))
    }
  }
}
