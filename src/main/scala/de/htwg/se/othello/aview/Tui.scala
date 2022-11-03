package de.htwg.se.othello.aview

import de.htwg.se.sudoku.model.{Grid}


class Tui {

  def processInputLine(input: String, grid:Grid):Grid = {
    input match {
      case "q" => grid
      case "n"=> new Grid(9)

    }
  }
}