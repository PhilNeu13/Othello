package de.htwg.se.othello
package controller

import model._
import util.{Observable, Observer, DoManager, Event}

trait ControllerInterface extends Observable:
  def doAndNotify(doThis: MoveCoordinates => FieldInterface, coordinates: MoveCoordinates): Unit
  def doAndNotify(doThis: => FieldInterface): Unit
  def put(move: MoveCoordinates): FieldInterface
  def quit(): Unit
  def undo: FieldInterface
  def redo: FieldInterface
  def toString: String