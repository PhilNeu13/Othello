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
var strategy(move: MoveCoordinates => Boolean) =
    if (turn == 1)
      stratPlayer1(move)
    else
      stratPlayer2(move)

