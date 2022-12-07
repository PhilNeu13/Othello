package de.htwg.se.othello
package aview

import controller.Controller
import model.{
  Stone,
  MoveCoordinates,
  Player,
  Field,
  PlayerQueue,
  TurnBlack,
  TurnWhite
}
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
