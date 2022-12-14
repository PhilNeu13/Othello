package de.htwg.se.othello
package aview

import controller.Controller
import model.MoveCoordinates
import model.playerComponent.{PlayerQueue, TurnBlack, TurnWhite, Player}
import model.fieldComponent.{Field}
import de.htwg.se.othello.model.stoneComponent.Stone
import scala.io.StdIn.readLine
import util.{Observer, Event}

trait UI(controller: Controller) extends Observer {
  controller.add(this)
  def start: Unit =
    update(Event.Move)
    controllMove
  def controllMove: Unit
  def makeAMove(eingabe: String): Option[MoveCoordinates]
}
