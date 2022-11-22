package de.htwg.se.othello
package aview

import controller.Controller
import model.{Stone, MoveCoordinates, Player, Field, Game, PlayerState}
import scala.io.StdIn.readLine
import util.Observer

class TUI(controller: Controller) extends Observer:
  controller.add(this)
  val pState = PlayerState

  def start =
    println("Before starting please enter the name of the first player!")
    val namePlayer1 = readLine()
    println(controller.addFirstPlayer(namePlayer1))
    println(
      "Now please enter the name of the second player to play."
    )
    val namePlayer2 = readLine()
    println(controller.addSecondPlayer(namePlayer2))
    println("")
    println(controller.field.toString)
    controllMove()

  override def update = {
    println(controller.field.toString)
  }

  def controllMove(): Unit =
    makeAMove(pState.strategy(pState.turn)) match
      case None       => return
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
        Some(MoveCoordinates(stone, x, y))
      }
    }
