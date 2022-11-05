package de.htwg.se.othello

import de.htwg.se.othello.model.Stone
import de.htwg.se.othello.model.Matrix
import de.htwg.se.othello.model.Field
import scala.io.StdIn._

@main def Othello: Unit =
  println("Welcome to Othello!")
  val field = new Field(6, Stone.Empty)
  println(field.toString)
  getInputAndPrintLoop(field)

def getInputAndPrintLoop(field: Field): Unit =
  print("To Play: Type in <W/B><x_value><y_value>!\nTo quit: Type q!\n")
  val input = readLine
  parseInput(input) match {
    case None => field
    case Some(newfield) =>
      println(newfield)
      getInputAndPrintLoop(newfield)
  }
  def parseInput(input: String): Option[Field] =
    input match
      case "q" => None
      case _ => {
        val chars = input.toCharArray
        val stone = chars(0) match {
          case 'W' => Stone.W
          case 'B' => Stone.B
          case _   => Stone.Empty
        }
        val x = chars(1).toString.toInt
        val y = chars(2).toString.toInt
        Some(field.put(stone, x - 1, y - 1))
      }
