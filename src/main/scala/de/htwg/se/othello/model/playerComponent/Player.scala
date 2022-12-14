package de.htwg.se.othello.model.playerComponent

//import de.htwg.se.othello.model.PlayerInterface
import de.htwg.se.othello.model.fieldComponent.Stone

case class Player(name: String, stone: Stone) /*extends PlayerInterface*/{

  override def toString: String =
    s"$name has Stone " + stone.toString()
}
