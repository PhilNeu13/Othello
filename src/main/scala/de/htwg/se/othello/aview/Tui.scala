package de.htwg.se.othello.aview

import de.htwg.se.othello.model.{Field,Stone,Matrix}
import scala.io.StdIn._

class Tui {
/*
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
            case 'w' => Stone.W
            case 'B' => Stone.B
            case 'b' => Stone.B
            case _   => Stone.Empty
            }
            val x = chars(1).toString.toInt
            val y = chars(2).toString.toInt
            Some(field.put(stone, y - 1, x - 1))
        }
        */
}