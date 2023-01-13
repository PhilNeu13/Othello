package de.htwg.se.othello.model.fileIoComponent

import de.htwg.se.othello.model.fieldComponent.FieldInterface

trait FileIOInterface {

  def load: FieldInterface
  def save(matrix: FieldInterface): Unit
}