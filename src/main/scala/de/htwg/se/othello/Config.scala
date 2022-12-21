package de.htwg.se.othello

import model.fieldComponent.{FieldBuilder}
import de.htwg.se.othello.model.Stone
import model.PlayerQueue
import aview.GUI
import scala.io.StdIn._
import controller.controllerComponent.Controller
import controller.controllerComponent.ControllerInterface
import model.fieldComponent.FieldInterface
import aview.TUI

object Config {
  val field = FieldBuilder(8, Stone.Empty).createOthelloField()
  given FieldInterface = field
  val playerQ = new PlayerQueue()
  given ControllerInterface = Controller(playerQ)
}