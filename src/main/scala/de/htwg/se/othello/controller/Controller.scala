package de.htwg.se.othello
package controller

import model._
import util.{Observable, Observer, DoManager, Event}
import scala.collection.mutable.ListBuffer

case class Controller(var field: Field, playerQ: PlayerQueue)
    extends Observable:
  val undoManager = new DoManager[Field]

  def addFirstPlayer(playerName: String): String =
    Player(playerName, Stone.B).toString

  def addSecondPlayer(playerName: String): String =
    Player(playerName, Stone.W).toString

  def doAndNotify(doThis: MoveCoordinates => Field, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers(Event.Move)

  def put(move: MoveCoordinates): Field =
    if (field.get(move.x, move.y) == Stone.Empty)
      playerQ.currentState.changeState()
      undoManager.doStep(field, CmdController(move))
    else field

  def quit: Unit = notifyObservers(Event.Quit)

  def doAndNotify(doThis: => Field) =
    field = doThis
    playerQ.currentState.changeState()
    notifyObservers(Event.Move)

  def undo: Field = undoManager.undoStep(field)

  def redo: Field = undoManager.redoStep(field)

  override def toString: String = field.toString
