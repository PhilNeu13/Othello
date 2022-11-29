package de.htwg.se.othello
package aview

import controller.Controller
import model.{Stone, MoveCoordinates, Player, Field}
import scala.io.StdIn.readLine
import de.htwg.se.othello.util.{Observer, PlayerState}

abstract class UI(controller: Controller) extends Observer {
  def start: Unit =
    update
    controllMove
  def controllMove: Unit
  def makeAMove(eingabe: String): Option[MoveCoordinates]
}
