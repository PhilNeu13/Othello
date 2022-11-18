package de.htwg.se.othello
package controller

import model.{Field, Stone, MoveCoordinates, Player}
import observe.{Observable, Observer}

case class Controller(var field: Field) extends Observable:

  def addFirstPlayer(playerName: String): String = {
    val player1 = Player(playerName, Stone.B)
    return player1.toString
  }
  def addSecondPlayer(playerName: String): String = {
    val player2 = Player(playerName, Stone.W)
    return player2.toString
  }

  def doAndNotify(doThis: MoveCoordinates => Field, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers
  def put(move: MoveCoordinates): Field =
    field.put(move.stone, move.x, move.y)
  override def toString: String = field.toString
