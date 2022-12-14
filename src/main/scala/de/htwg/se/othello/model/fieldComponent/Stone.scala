package de.htwg.se.othello.model.fieldComponent

//import de.htwg.se.othello.model.FieldInterface

enum Stone(stringRep: String) /*extends FieldInterface*/{
  override def toString = stringRep
  case W extends Stone("W")
  case B extends Stone("B")
  case Empty extends Stone(" ")
}
