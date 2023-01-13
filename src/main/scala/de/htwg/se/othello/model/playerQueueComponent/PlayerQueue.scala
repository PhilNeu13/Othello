package de.htwg.se.othello.model.playerQueueComponent

import de.htwg.se.othello.model.playerQueueComponent.{PlayerQueueInterface}
import de.htwg.se.othello.model.MoveCoordinates
import de.htwg.se.othello.model.fieldComponent
import de.htwg.se.othello.model.Stone
import scala.util.{Success, Failure, Try}
import org.scalactic.Bool
import java.lang.invoke.WrongMethodTypeException

class PlayerQueue extends PlayerQueueInterface {
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