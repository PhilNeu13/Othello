package de.htwg.se.othello
package util
import de.htwg.se.othello.model.{Field, MoveCoordinates, Stone}
import scala.collection.mutable.ListBuffer

object CheckStone {

  def hasDifferentStone(x: Int, y: Int, stone: Stone, field: Field): Boolean = {
    !field.get(x, y).equals(stone) && !field.get(x, y).equals(Stone.Empty)
  }

  def strategy(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] =
    if (
      hasDifferentStone(move.x + 1, move.y + 1, move.stone, field)
    ) // Second Stone top right
      strategyTopRight(move, field)
    if (
      hasDifferentStone(move.x, move.y + 1, move.stone, field)
    ) // Second Stone top
      strategyTop(move, field)
    if (
      hasDifferentStone(move.x + 1, move.y, move.stone, field)
    ) // Second Stone right
      strategyRight(move, field)
    if (
      hasDifferentStone(move.x + 1, move.y - 1, move.stone, field)
    ) // Second Stone bottom right
      strategyBottomRight(move, field)
    if (
      hasDifferentStone(move.x, move.y - 1, move.stone, field)
    ) // Second Stone bottom
      strategyBottom(move, field)
    if (
      hasDifferentStone(move.x - 1, move.y - 1, move.stone, field)
    ) // Second Stone bottom left
      strategyBottomLeft(move, field)
    if (
      hasDifferentStone(move.x - 1, move.y, move.stone, field)
    ) // Second Stone left
      strategyRight(move, field)
    if (hasDifferentStone(move.x - 1, move.y + 1, move.stone, field)) // Second Stone top left
      strategyTopLeft(move, field)
    else
      val list = new ListBuffer[MoveCoordinates]
      list
  /*trait Strategy {
		def execute(m: MoveCoordinates, f: Field): ListBuffer[MoveCoordinates]
	}*/

  private def strategyTopRight(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x + 1, move.y + 1, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x + 1, move.y + 1)
        stonesInBetween.concat(strategyTopRight(nextStone, field))
      }
    }
    stonesInBetween
  }

  private def strategyTop(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x, move.y + 1, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x, move.y + 1)
        stonesInBetween.concat(strategyRight(nextStone, field))
      }
    }
    stonesInBetween
  }

  private def strategyRight(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x + 1, move.y, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x + 1, move.y)
        stonesInBetween.concat(strategyRight(nextStone, field))
      }
    }
    stonesInBetween
  }

  private def strategyBottomRight(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x + 1, move.y - 1, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x + 1, move.y - 1)
        stonesInBetween.concat(strategyBottomRight(nextStone, field))
      }
    }
    stonesInBetween

  }

  private def strategyBottom(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x, move.y - 1, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x, move.y - 1)
        stonesInBetween.concat(strategyRight(nextStone, field))
      }
    }
    stonesInBetween
  }

  private def strategyBottomLeft(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x - 1, move.y - 1, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x - 1, move.y - 1)
        stonesInBetween.concat(strategyBottomLeft(nextStone, field))
      }
    }
    stonesInBetween
  }

  private def strategyLeft(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x - 1, move.y, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x - 1, move.y)
        stonesInBetween.concat(strategyLeft(nextStone, field))
      }
    }
    stonesInBetween
  }

  private def strategyTopLeft(
      move: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(move.x, move.y).equals(Stone.Empty)) {
      if (hasDifferentStone(move.x - 1, move.y + 1, move.stone, field)) {
        stonesInBetween += move
        val nextStone =
          new MoveCoordinates(move.stone, move.x - 1, move.y + 1)
        stonesInBetween.concat(strategyTopLeft(nextStone, field))
      }
    }
    stonesInBetween
  }

  def flipStone(
      list: ListBuffer[MoveCoordinates],
      field: Field,
      stone: Stone
  ): Field = {
    list.foreach(el => field.put(el.stone, el.x, el.y))
    field
  }
}
