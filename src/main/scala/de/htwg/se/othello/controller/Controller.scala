package de.htwg.se.othello
package controller

import model.{Field, Stone, MoveCoordinates, Player}
import observe.{Observable, Observer}

case class Controller(var field: Field) extends Observable:
  private val players = new Array[Player](2)

  def addFirstPlayer(playerName: String) = {
    players(0) = Player(playerName, Stone.B)
  }
  def addSecondPlayer(playerName: String) = {
    players(1) = Player(playerName, Stone.W)
  }

  def doAndNotify(doThis: MoveCoordinates => Field, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers
  def put(move: MoveCoordinates): Field =
    field.put(move.stone, move.x, move.y)
  override def toString: String = field.toString
