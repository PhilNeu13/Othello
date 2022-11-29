package de.htwg.se.othello
package aview

import controller.Controller
import model.{Stone, MoveCoordinates, Player, Field}
import scala.io.StdIn.readLine
import util.{Observer, PlayerState}

class TUI(controller: Controller) extends UI(controller):
  controller.add(this)
  val pState = PlayerState
  override def update = {
    println(controller.field.toString)
  }

  def controllMove: Unit =
    println("To Play: Type in <W/B><x_value><y_value>!\nTo quit: Type q!\n")
    makeAMove(readLine()) match
      case None =>
      case Some(move) =>
        if (pState.strategy(pState.turn, move))
          controller.doAndNotify(controller.put, move)
    controllMove

  def makeAMove(eingabe: String): Option[MoveCoordinates] =
    eingabe match {
      case "q" => None
      case "u" => controller.doAndNotify(controller.undo); None
      case "r" => controller.doAndNotify(controller.redo); None
      case _ => {
        val chars = eingabe.toCharArray
        val stone = chars(0) match {
          case 'B' => Stone.B
          case 'W' => Stone.W
          case _   => Stone.Empty
        }
        val x = chars(1).toString.toInt
        val y = chars(2).toString.toInt
        Some(MoveCoordinates(stone, x, y))
      }
    }
