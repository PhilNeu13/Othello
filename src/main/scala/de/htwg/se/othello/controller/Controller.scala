package de.htwg.se.othello
package controller

import model.{Field, Stone, MoveCoordinates, Player}
import util.{Observable, Observer, PlayerState, UndoManager}
import scala.collection.mutable.ListBuffer

case class Controller(var field: Field) extends Observable:
  val undoManager = new UndoManager[Field]

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
      undoManager.doStep(field, CmdController(move))
    else field

  def doAndNotify(doThis: => Field) =
    field = doThis
    notifyObservers

  def undo: Field = undoManager.undoStep(field)

  def redo: Field = undoManager.redoStep(field)

  override def toString: String = field.toString
