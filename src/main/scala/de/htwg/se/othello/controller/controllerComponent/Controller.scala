package de.htwg.se.othello.controller.controllerComponent

import de.htwg.se.othello.model.playerQueueComponent.PlayerQueueInterface
import de.htwg.se.othello.model.fieldComponent.FieldInterface
import de.htwg.se.othello.model._
import de.htwg.se.othello.util.{Observer,Observable, DoManager, Event}
import scala.collection.mutable.ListBuffer

import de.htwg.se.othello.Config.{given}

class Controller(using var field: FieldInterface, playerQ: PlayerQueueInterface)
    extends Observable with ControllerInterface():
  val undoManager = new DoManager[FieldInterface]

  def addFirstPlayer(playerName: String): String =
    Player(playerName, Stone.B).toString

  def addSecondPlayer(playerName: String): String =
    Player(playerName, Stone.W).toString

  def doAndNotify(doThis: MoveCoordinates => FieldInterface, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers(Event.Move)

  def getField: FieldInterface =
    field

  def put(move: MoveCoordinates): FieldInterface =
    if (field.get(move.x, move.y) == Stone.Empty)
      playerQ.currentState.changeState()
      undoManager.doStep(field, CmdController(move))
    else field

  def quit(): Unit = notifyObservers(Event.Quit)

  def doAndNotify(doThis: => FieldInterface) =
    field = doThis
    playerQ.currentState.changeState()
    notifyObservers(Event.Move)

  def undo: FieldInterface = undoManager.undoStep(field)

  def redo: FieldInterface = undoManager.redoStep(field)

  override def toString: String = field.toString
