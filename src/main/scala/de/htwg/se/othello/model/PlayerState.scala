
package de.htwg.se.othello.model

import de.htwg.se.othello.model.MoveCoordinates
import de.htwg.se.othello.model.fieldComponent
import de.htwg.se.othello.model.Stone
import scala.util.{Success, Failure, Try}
import org.scalactic.Bool
import java.lang.invoke.WrongMethodTypeException
import playerQueueComponent.PlayerQueueInterface


class PlayerStrat(playerQ: PlayerQueueInterface){
  def strategy(
      move: MoveCoordinates
  ) =
    if (playerQ.currentState.getStone() ==  Stone.B)
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