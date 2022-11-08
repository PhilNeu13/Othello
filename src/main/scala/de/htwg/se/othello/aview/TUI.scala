package de.htwg.se.othello
package aview

import controller.Controller
import model.Stone
import scala.io.StdIn.readLine
import observe.Observer

class TUI(controller: Controller) extends Observer:
  controller.add(this)
  def run =
    println(controller.field.toString)
    getInputAndPrintLoop()

  override def update = ???

  def getInputAndPrintLoop(): Unit =
    println("To Play: Type in <W/B><x_value><y_value>!\nTo quit: Type q!\n")
    val input = readLine
    input match
      case "q" =>
      case _ => {
        val chars = input.toCharArray
        val stone = chars(0) match
          case 'X' => Stone.B
          case 'O' => Stone.W
          case _   => Stone.Empty
        val x = chars(1).toString.toInt
        val y = chars(2).toString.toInt
        controller.put(stone, x, y)
        println(controller.toString)
        getInputAndPrintLoop()
      }
