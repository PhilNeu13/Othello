package de.htwg.se.othello.model.playerComponent

//import de.htwg.se.othello.model.playerComponent.PlayerInterface
import de.htwg.se.othello.model.MoveCoordinates
import de.htwg.se.othello.model.fieldComponent
import de.htwg.se.othello.model.stoneComponent.Stone
import scala.util.{Success, Failure, Try}
import org.scalactic.Bool
import java.lang.invoke.WrongMethodTypeException

class PlayerQueue /*extends PlayerInterface*/{
  var black: State = new TurnBlack(this)
  var white: State = new TurnWhite(this)
  var currentState: State = new TurnBlack(this)
  var prevState: State = new TurnWhite(this)

  def changeState(): Unit = currentState.changeState()
}

trait State {
  def changeState(): Unit
  def getStone(): Stone
}

class TurnBlack(playerQueue: PlayerQueue) extends State {

  def changeState(): Unit =
    playerQueue.prevState = this
    playerQueue.currentState = playerQueue.white

  def getStone(): Stone =
    Stone.B
}

class TurnWhite(playerQueue: PlayerQueue) extends State {
  def changeState(): Unit =
    playerQueue.prevState = this
    playerQueue.currentState = playerQueue.black

  def getStone(): Stone =
    Stone.W

}
class PlayerStrat(playerQ: PlayerQueue) /*extends PlayerInterface */{
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
