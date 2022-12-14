package de.htwg.se.othello
package controller

import model.playerComponent._
import de.htwg.se.othello.model.stoneComponent.Stone
import model.fieldComponent.FieldInterface
import model.MoveCoordinates
import util.{Observable, Observer, DoManager, Event}
import scala.collection.mutable.ListBuffer

case class Controller(var field: FieldInterface, playerQ: PlayerQueue)
    extends Observable:
  val undoManager = new DoManager[FieldInterface]

  def addFirstPlayer(playerName: String): String =
    Player(playerName, Stone.B).toString

  def addSecondPlayer(playerName: String): String =
    Player(playerName, Stone.W).toString

  def doAndNotify(doThis: MoveCoordinates => FieldInterface, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers(Event.Move)

  def put(move: MoveCoordinates): FieldInterface =
    if (field.get(move.x, move.y) == Stone.Empty)
      playerQ.currentState.changeState()
      undoManager.doStep(field, CmdController(move))
    else field

  def quit: Unit = notifyObservers(Event.Quit)

  def doAndNotify(doThis: => FieldInterface) =
    field = doThis
    playerQ.currentState.changeState()
    notifyObservers(Event.Move)

  def undo: FieldInterface = undoManager.undoStep(field)

  def redo: FieldInterface = undoManager.redoStep(field)

  override def toString: String = field.toString
