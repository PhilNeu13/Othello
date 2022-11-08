package de.htwg.se.othello
package controller

import model.Field
import model.Stone
import observe.{Observable, Observer}

case class Controller(var field: Field) extends Observable:
  def put(stone: Stone, x: Int, y: Int): Unit =
    field = field.put(stone, x, y)
    notifyObservers
  override def toString: String = field.toString
