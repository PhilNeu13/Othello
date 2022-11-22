package de.htwg.se.othello
package controller

import model.{Field, Stone, MoveCoordinates, Player, Game, PlayerState}
import util.{Observable, Observer}
import util.CheckStone
import scala.collection.mutable.ListBuffer

case class Controller(var field: Field) extends Observable:

  def addFirstPlayer(playerName: String): String =
    Player(playerName, Stone.B).toString

  def addSecondPlayer(playerName: String): String =
    Player(playerName, Stone.W).toString

  def doAndNotify(doThis: MoveCoordinates => Field, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers
  def put(move: MoveCoordinates): Field =
    if (field.get(move.x, move.y) == Stone.Empty)
      PlayerState.changeState
      field.put(move.stone, move.x, move.y)
    else field
  override def toString: String = field.toString
