package de.htwg.se.othello
package aview

import controller.Controller
<<<<<<< Updated upstream
import model.{Stone, MoveCoordinates, Player, Field, PlayerQueue, TurnBlack, TurnWhite}
=======
import model.MoveCoordinates
import model.playerComponent.{PlayerQueue, TurnBlack, TurnWhite, Player}
import model.fieldComponent.{Field}
import de.htwg.se.othello.model.stoneComponent.Stone
>>>>>>> Stashed changes
import scala.io.StdIn.readLine
import de.htwg.se.othello.util.{Observer}

abstract class UI(controller: Controller) extends Observer {
  def start: Unit =
    update
    controllMove
  def controllMove: Unit
  def makeAMove(eingabe: String): Option[MoveCoordinates]
}
