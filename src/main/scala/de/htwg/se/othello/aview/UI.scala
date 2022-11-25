package de.htwg.se.othello
package aview

import controller.Controller
import model.{Stone, MoveCoordinates, Player, Field}
import scala.io.StdIn.readLine
import de.htwg.se.othello.util.{Observer, PlayerState}

trait UI(controller: Controller) extends Observer {
  def start: Unit
  def controllMove(eingabe: String): Unit
  def makeAMove(eingabe: String): Option[MoveCoordinates]
}
