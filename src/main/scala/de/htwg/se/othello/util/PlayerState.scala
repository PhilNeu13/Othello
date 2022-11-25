package de.htwg.se.othello.util

import de.htwg.se.othello.model.Stone
import scala.io.StdIn.readLine
import de.htwg.se.othello.model.MoveCoordinates

object PlayerState {
  var turn: Int = player1

  def getStone: Stone = {
    turn match {
      case 1 => Stone.B
      case 2 => Stone.W
    }
  }

  def changeState = {
    turn match {
      case 1 => turn = player2
      case 2 => turn = player1
    }
    turn
  }

  def player1: Int = 1
  def player2: Int = 2

  def strategy(turn: Int, move: MoveCoordinates) =
    if (turn == 1)
      stratPlayer1(move)
    else
      stratPlayer2(move)

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
