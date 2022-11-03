package de.htwg.se.othello.model

final case class Player(name: String, points: Int = 0, stone: Stone)

val phil = Player(name = "Phil", stone = Stone.W)
val lukas = Player(name = "Lukas", stone = Stone.B)

object Player:
  val list = List(phil, lukas)
  def next = list.iterator.next