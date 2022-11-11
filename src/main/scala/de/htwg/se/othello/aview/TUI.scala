package de.htwg.se.othello
package aview

import controller.Controller
import model.Stone
import scala.io.StdIn.readLine
import observe.Observer

class TUI(controller: Controller) extends Observer:
  controller.add(this)

  def start =
    println(controller.field.toString)
    makeAMove()

  override def update = {}

  def makeAMove(): Unit =
    println("To Play: Type in <W/B><x_value><y_value>!\nTo quit: Type q!\n")
    val input = readLine
    input match {
      case "q" =>
      case _ => {
        val chars = input.toCharArray
        val stone = chars(0) match {
          case 'B' => Stone.B
          case 'W' => Stone.W
          case _   => Stone.Empty
        }
        val x = chars(1).toString.toInt
        val y = chars(2).toString.toInt
        controller.put(stone, x - 1, y - 1)
        println(controller.toString)
        makeAMove()
      }
    }
