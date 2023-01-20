package de.htwg.se.othello.model

import de.htwg.se.othello.model.Stone

case class Player(name: String, stone: Stone) {

  override def toString: String =
    s"$name has Stone " + stone.toString()
}