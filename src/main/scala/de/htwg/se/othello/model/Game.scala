/*package de.htwg.se.othello.model

import scala.compiletime.ops.boolean

case class Game(
    field: Field,
    players: Array[Player],
    currentPlayer: Player,
    setStones: Int = 0
) {
  override def equals(game: Any): Boolean = game match {
    case g: Game =>
      g.field.equals(field) && g.players.sameElements(players)
    case _ => false
  }
  def isValidSet(move: MoveCoordinates, field: Field): Boolean =
    move.x < field.size && move.x >= 0 && move.y < field.size
      && move.y >= 0 && field.get(move.x, move.y) == Stone.Empty

  def isGameOver(field: Field): Boolean =
    setStones == field.size * field.size

  def isEmpty(field: Field): Boolean =
    setStones == 0
}
*/