package de.htwg.se.othello.model

import scala.io.StdIn.readLine

object PlayerState {
  var turn: Int = player1

  def getStone: Stone = {
    turn match {
      case 1 => Stone.B
      case 2 => Stone.W
    }
  }

  def changeState = {
    turn match {
      case 1 => turn = player2
      case 2 => turn = player1
    }
    turn
  }

  def player1: Int = 1
  def player2: Int = 2

  def strategy(state: Int) =
    if (turn == 1)
      stratPlayer1
    else
      stratPlayer2

  def stratPlayer1: String = {
    println("Player1's turn!\n")
    println("To Play: Type in <B><x_value><y_value>!\nTo quit: Type q!\n")
    val input = readLine()
    val move = input.toCharArray()
    move(0) match {
      case 'W' =>
        println("Wrong Input")
        stratPlayer1
      case _ =>
        input
    }
  }

  def stratPlayer2: String = {
    println("Player2's turn!\n")
    println("To Play: Type in <W><x_value><y_value>!\nTo quit: Type q!\n")
    val input = readLine()
    val move = input.toCharArray()
    move(0) match {
      case 'B' =>
        println("Wrong Input")
        stratPlayer2
      case _ =>
        input
    }
  }
}
