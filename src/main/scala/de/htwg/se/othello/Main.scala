package de.htwg.se.othello

import de.htwg.se.othello.model.Stone
import de.htwg.se.othello.model.Matrix

import de.htwg.se.othello.model.{FieldBuilder, Field}

import scala.io.StdIn._
import controller.Controller
import aview.TUI
import de.htwg.se.othello.util.PlayerQueue

@main def Othello: Unit =
  println("\nWelcome to Othello!")
  val field = FieldBuilder(8, Stone.Empty).createOthelloField()
  val playerQ = new PlayerQueue()
  val controller = Controller(field, playerQ)
  val tui = TUI(controller, playerQ)
  tui.start
