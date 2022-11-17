package de.htwg.se.othello
package controller

import model.{Field, Stone, MoveCoordinates}
import observe.{Observable, Observer}

case class Controller(var field: Field) extends Observable:
  def doAndNotify(doThis: MoveCoordinates => Field, move: MoveCoordinates) =
    field = doThis(move)
    notifyObservers
  def put(move: MoveCoordinates): Field =
    field.put(move.stone, move.x, move.y)
  override def toString: String = field.toString
