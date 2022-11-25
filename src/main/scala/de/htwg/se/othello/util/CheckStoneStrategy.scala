package de.htwg.se.othello.util
import de.htwg.se.othello.model.*
import scala.collection.mutable.ListBuffer
//import scala.annotation.meta.field.apply

object CheckStone {

  def strategy(
      prevMove: MoveCoordinates,
      presMove: MoveCoordinates,
      field: Field
  ) =
    if (
      prevMove.x > presMove.x && prevMove.y > presMove.y
    ) // Second Stone top right
      strategyTopRight(prevMove, field)
    else if (
      prevMove.x == presMove.x && prevMove.y < presMove.y
    ) // Second Stone top
      strategyTop(prevMove, field)
    else if (
      prevMove.x > presMove.x && prevMove.y == presMove.y
    ) // Second Stone right
      strategyRight(prevMove, field)
    else if (
      prevMove.x > presMove.x && prevMove.y < presMove.y
    ) // Second Stone bottom right
      strategyBottomRight(prevMove, field)
    else if (
      prevMove.x == presMove.x && prevMove.y > presMove.y
    ) // Second Stone bottom
      strategyBottom(prevMove, field)
    else if (
      prevMove.x < presMove.x && prevMove.y < presMove.y
    ) // Second Stone bottom left
      strategyBottomLeft(prevMove, field)
    else if (
      prevMove.x < presMove.x && prevMove.y == presMove.y
    ) // Second Stone right
      strategyRight(prevMove, field)
    else if (
      prevMove.x < presMove.x && prevMove.y > presMove.y
    ) // Second Stone top left
      strategyTopLeft(prevMove, field)
  /*trait Strategy {
		def execute(m: MoveCoordinates, f: Field): ListBuffer[MoveCoordinates]
	}*/

  private def strategyTopRight(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x + 1, firstMove.y + 1).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x + 1, firstMove.y + 1)
      stonesInBetween.concat(strategyTopRight(nextStone, field))
    }
    stonesInBetween
  }

  private def strategyTop(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x, firstMove.y + 1).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x, firstMove.y + 1)
      stonesInBetween.concat(strategyRight(nextStone, field))
    }
    stonesInBetween
  }

  private def strategyRight(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x + 1, firstMove.y).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x + 1, firstMove.y)
      stonesInBetween.concat(strategyRight(nextStone, field))
    }
    stonesInBetween
  }

  private def strategyBottomRight(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x + 1, firstMove.y - 1).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x + 1, firstMove.y - 1)
      stonesInBetween.concat(strategyBottomRight(nextStone, field))
    }
    stonesInBetween

  }

  private def strategyBottom(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x, firstMove.y - 1).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x, firstMove.y - 1)
      stonesInBetween.concat(strategyRight(nextStone, field))
    }
    stonesInBetween
  }

  private def strategyBottomLeft(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x - 1, firstMove.y - 1).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x - 1, firstMove.y - 1)
      stonesInBetween.concat(strategyBottomLeft(nextStone, field))
    }
    stonesInBetween
  }

  private def strategyLeft(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x - 1, firstMove.y).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x - 1, firstMove.y)
      stonesInBetween.concat(strategyLeft(nextStone, field))
    }
    stonesInBetween
  }

  private def strategyTopLeft(
      firstMove: MoveCoordinates,
      field: Field
  ): ListBuffer[MoveCoordinates] = {
    var stonesInBetween = new ListBuffer[MoveCoordinates]
    if (!field.get(firstMove.x - 1, firstMove.y + 1).equals(firstMove.stone)) {
      stonesInBetween += firstMove
      val nextStone =
        new MoveCoordinates(firstMove.stone, firstMove.x - 1, firstMove.y + 1)
      stonesInBetween.concat(strategyTopLeft(nextStone, field))
    }
    stonesInBetween
  }
}
