package de.htwg.se.othello.model

enum Stone(stringRep: String){
  override def toString = stringRep
  case W extends Stone("W")
  case B extends Stone("B")
  case Empty extends Stone(" ")
}
