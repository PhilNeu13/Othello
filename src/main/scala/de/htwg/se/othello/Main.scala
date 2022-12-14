package de.htwg.se.othello

<<<<<<< Updated upstream
import de.htwg.se.othello.model.Stone
import de.htwg.se.othello.model.Matrix
import de.htwg.se.othello.model.{FieldBuilder, Field}
=======
import model.fieldComponent.{FieldBuilder}
import de.htwg.se.othello.model.stoneComponent.Stone
import model.playerComponent.PlayerQueue
import aview.GUI
>>>>>>> Stashed changes
import scala.io.StdIn._
import controller.Controller
import aview.TUI

@main def Othello: Unit =
  println("\nWelcome to Othello!")
  val field = FieldBuilder(8, Stone.Empty).createOthelloField()
  val controller = Controller(field)
  val tui = TUI(controller)
  tui.start
