package de.htwg.se.othello.model

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
object PlayerState {
  def strategy(
      currentState: State,
      move: MoveCoordinates,
      playerQ: PlayerQueue
  ) =
    if (currentState == playerQ.currentState)
      stratPlayer1(move)
    else stratPlayer2(move)

  def stratPlayer1(move: MoveCoordinates): Boolean = {
    move.stone match {
      case Stone.B => true
      case _       => false
    }
  }

  def stratPlayer2(move: MoveCoordinates): Boolean = {
    move.stone match {
      case Stone.W => true
      case _       => false
    }
  }
}
