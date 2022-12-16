package de.htwg.se.othello
package aview

import controller.controllerComponent.{ControllerInterface}
import model.MoveCoordinates
import model.{PlayerQueue, TurnBlack, TurnWhite, Player}
import model.fieldComponent.{Field}
import de.htwg.se.othello.model.Stone
import scala.io.StdIn.readLine
import util.{Observer, Event}

trait UI(controller: ControllerInterface) extends Observer {
  controller.add(this)
  def start: Unit =
    update(Event.Move)
    controllMove
  def controllMove: Unit
  def makeAMove(eingabe: String): Option[MoveCoordinates]
}
