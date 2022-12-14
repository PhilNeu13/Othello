package de.htwg.se.othello

import model.fieldComponent.{FieldBuilder, Stone}
import model.playerComponent.PlayerQueue
import aview.GUI
import scala.io.StdIn._
import controller.Controller
import aview.TUI

@main def Othello: Unit =
  println("\nWelcome to Othello!")
  val field = FieldBuilder(8, Stone.Empty).createOthelloField()
  val playerQ = new PlayerQueue()
  val controller = Controller(field, playerQ)
  val gui = GUI(controller, playerQ)
  gui.start
  val tui = TUI(controller, playerQ)
  tui.start
