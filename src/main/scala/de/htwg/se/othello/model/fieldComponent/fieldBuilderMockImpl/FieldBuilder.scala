package de.htwg.se.othello.model.fieldComponent.fieldBuilderMockImpl

import de.htwg.se.othello.model.fieldComponent.FieldBuilderInterface
import de.htwg.se.othello.model.stoneComponent.Stone

class FieldBuilder(var size: Int) extends FieldBuilderInterface {
  size = 1
  def createEmptyField(): FieldBuilderInterface = this
  def createOthelloField(): FieldBuilderInterface = this
}