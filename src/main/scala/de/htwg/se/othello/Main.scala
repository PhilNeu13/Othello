package de.htwg.se.othello

<<<<<<< Updated upstream
import de.htwg.se.othello.model.Stone
import de.htwg.se.othello.model.Matrix

import de.htwg.se.othello.model.{FieldBuilder, Field}
<<<<<<< HEAD
=======
import model.fieldComponent.{FieldBuilder}
import de.htwg.se.othello.model.stoneComponent.Stone
import model.playerComponent.PlayerQueue
import aview.GUI
>>>>>>> Stashed changes
=======

>>>>>>> 55aa3ddd1ea5ab83f7a01804ae80553dbdc021d2
import scala.io.StdIn._
import controller.Controller
import aview.TUI

@main def Othello: Unit =
  println("\nWelcome to Othello!")
  val field = FieldBuilder(8, Stone.Empty).createOthelloField()
  val controller = Controller(field)
  val tui = TUI(controller)
  tui.start
