package de.htwg.se.othello.controller.controllerComponent

import de.htwg.se.othello.model._
import de.htwg.se.othello.model.fieldComponent.FieldInterface
import de.htwg.se.othello.util.{Observable, Observer, DoManager, Event}

trait ControllerInterface extends Observable:
  def doAndNotify(doThis: MoveCoordinates => FieldInterface, coordinates: MoveCoordinates): Unit
  def doAndNotify(doThis: => FieldInterface): Unit
  def put(move: MoveCoordinates): FieldInterface
  def quit(): Unit
  def undo: FieldInterface
  def redo: FieldInterface
  def toString: String