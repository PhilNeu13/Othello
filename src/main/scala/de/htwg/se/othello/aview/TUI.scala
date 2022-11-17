package de.htwg.se.othello
package aview

import controller.Controller
import model.{Stone, MoveCoordinates}
import scala.io.StdIn.readLine
import observe.Observer

class TUI(controller: Controller) extends Observer:
  controller.add(this)

  def start =
    println(controller.field.toString)
    controllMove()

  override def update = {
    println(controller.field.toString)
  }

  def controllMove(): Unit =
    println("To Play: Type in <W/B><x_value><y_value>!\nTo quit: Type q!\n")
    makeAMove(readLine) match
      case None       => sys.exit(0)
      case Some(move) => controller.doAndNotify(controller.put, move)
    controllMove()

  def makeAMove(eingabe: String): Option[MoveCoordinates] =
    eingabe match {
      case "q" => None
      case _ => {
        val chars = eingabe.toCharArray
        val stone = chars(0) match {
          case 'B' => Stone.B
          case 'W' => Stone.W
          case _   => Stone.Empty
        }
        val x = chars(1).toString.toInt
        val y = chars(2).toString.toInt
        Some(MoveCoordinates(stone, x - 1, y - 1))
      }
    }
