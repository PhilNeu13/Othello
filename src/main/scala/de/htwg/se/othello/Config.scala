package de.htwg.se.othello

import model.fieldComponent.{FieldBuilder}
import de.htwg.se.othello.model.Stone
import model.playerQueueComponent.{PlayerQueueInterface, PlayerQueue}
//import model.playerQueueComponent.PlayerQueue
import aview.GUI
import controller.controllerComponent.Controller
import controller.controllerComponent.ControllerInterface
//import de.htwg.se.othello.model.fileIOComponent.fileIOxmlimpl.FileIO
import de.htwg.se.othello.model.fileIOComponent.fileIOjsonimpl.FileIO
import de.htwg.se.othello.model.fileIOComponent.FileIOInterface
import model.fieldComponent.FieldInterface
import aview.TUI

object Config {
  val field = FieldBuilder(8, Stone.Empty).createOthelloField()
  given FieldInterface = field
  val playerQ = new PlayerQueue()
  given PlayerQueueInterface = playerQ
  given FileIOInterface = FileIO()
  given ControllerInterface = Controller()
}