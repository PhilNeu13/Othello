package de.htwg.se.othello.util

import de.htwg.se.othello.model.fieldComponent.FieldInterface

trait Command[FieldInterface]:
  def doStep(field: FieldInterface): FieldInterface
  def undoStep(field: FieldInterface): FieldInterface
  def redoStep(field: FieldInterface): FieldInterface

class DoManager[FieldInterface]:
  private var undoStack: List[Command[FieldInterface]] = Nil
  private var redoStack: List[Command[FieldInterface]] = Nil

  def doStep(field: FieldInterface, command: Command[FieldInterface]): FieldInterface =
    undoStack = command :: undoStack
    redoStack = redoStack.empty
    command.doStep(field)

  def undoStep(field: FieldInterface): FieldInterface =
    undoStack match {
      case Nil => field
      case head :: stack => {
        val result = head.undoStep(field)
        undoStack = stack
        redoStack = head :: redoStack
        result
      }
    }
  def redoStep(field: FieldInterface): FieldInterface =
    redoStack match {
      case Nil => field
      case head :: stack => {
        val result = head.redoStep(field)
        redoStack = stack
        undoStack = head :: undoStack
        result
      }
    }
