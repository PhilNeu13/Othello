package de.htwg.se.othello.util

import de.htwg.se.othello.model.Field

trait Command[Field]:
  def doStep(field: Field): Field
  def undoStep(field: Field): Field
  def redoStep(field: Field): Field

class UndoManager[Field]:
  private var undoStack: List[Command[Field]] = Nil
  private var redoStack: List[Command[Field]] = Nil

  def doStep(field: Field, command: Command[Field]): Field =
    undoStack = command :: undoStack
    redoStack = redoStack.empty
    command.doStep(field)

  def undoStep(field: Field): Field =
    undoStack match {
      case Nil => field
      case head :: stack => {
        val result = head.undoStep(field)
        undoStack = stack
        redoStack = head :: redoStack
        result
      }
    }
  def redoStep(field: Field): Field =
    redoStack match {
      case Nil => field
      case head :: stack => {
        val result = head.redoStep(field)
        redoStack = stack
        undoStack = head :: undoStack
        result
      }
    }
