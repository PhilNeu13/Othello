package de.htwg.se.othello

import model.fieldComponent.{FieldBuilder}
import de.htwg.se.othello.model.Stone
import model.playerQueueComponent.PlayerQueueInterface
import model.playerQueueComponent.PlayerQueue
import aview.GUI
import scala.io.StdIn._
import controller.controllerComponent.Controller
import aview.TUI
import de.htwg.se.othello.Config.{given}


@main def Othello: Unit =
  println("\nWelcome to Othello!")
  //val field = FieldBuilder(8, Stone.Empty).createOthelloField()
  //new PlayerQueue()
  //val controller = Controller(playerQ)
  new GUI().start
  new TUI().start
  while(true){}
  
