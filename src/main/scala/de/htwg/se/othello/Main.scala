package de.htwg.se.othello

import de.htwg.se.othello.model.Stone
import de.htwg.se.othello.model.Matrix
<<<<<<< HEAD
import de.htwg.se.othello.model.{FieldBuilder, Field}
=======
import de.htwg.se.othello.model.Field
import de.htwg.se.othello.model.FieldBuilder
>>>>>>> 6cc056d0aa64d760bcba8ec77628f029bed0764c
import scala.io.StdIn._
import controller.Controller
import aview.TUI

@main def Othello: Unit =
  println("\nWelcome to Othello!")
<<<<<<< HEAD
  val field = FieldBuilder(8, Stone.Empty).createOthelloField()
=======
  val field= FieldBuilder(8, Stone.Empty).createOthelloField()
>>>>>>> 6cc056d0aa64d760bcba8ec77628f029bed0764c
  val controller = Controller(field)
  val tui = TUI(controller)
  tui.start
