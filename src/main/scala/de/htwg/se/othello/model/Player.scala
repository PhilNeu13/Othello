package de.htwg.se.othello.model

case class Player(name: String, stone: Stone) {
  override def toString: String =
    s"$name has Stone " + stone.toString()
}
