package de.htwg.se.othello
package controller

<<<<<<< Updated upstream
import model._
import util.{Observable, Observer, UndoManager}
import scala.collection.mutable.ListBuffer

case class Controller(var field: Field) extends Observable:
  val undoManager = new UndoManager[Field]
  
  val playerQueue = new PlayerQueue()
=======
import model.playerComponent._
import de.htwg.se.othello.model.stoneComponent.Stone
import model.fieldComponent.FieldInterface
import model.MoveCoordinates
import util.{Observable, Observer, DoManager, Event}
import scala.collection.mutable.ListBuffer

case class Controller(var field: FieldInterface, playerQ: PlayerQueue)
    extends Observable:
  val undoManager = new DoManager[FieldInterface]
>>>>>>> Stashed changes

  def change_Player(): Unit = 
    playerQueue.changeState()
  
  def addFirstPlayer(playerName: String): String =
    Player(playerName, Stone.B).toString

  def addSecondPlayer(playerName: String): String =
    Player(playerName, Stone.W).toString

  def doAndNotify(doThis: MoveCoordinates => FieldInterface, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers

  def put(move: MoveCoordinates): FieldInterface =
    if (field.get(move.x, move.y) == Stone.Empty)
      change_Player()
      undoManager.doStep(field, CmdController(move))
    else field

<<<<<<< Updated upstream
  def doAndNotify(doThis: => Field) =
=======
  def quit: Unit = notifyObservers(Event.Quit)

  def doAndNotify(doThis: => FieldInterface) =
>>>>>>> Stashed changes
    field = doThis
    notifyObservers

  def undo: FieldInterface = undoManager.undoStep(field)

  def redo: FieldInterface = undoManager.redoStep(field)

  override def toString: String = field.toString
