package de.htwg.se.othello.model.fieldComponent.fieldMockImpl

import de.htwg.se.othello.model.fieldComponent.FieldInterface
import de.htwg.se.othello.model.fieldComponent.Matrix
import de.htwg.se.othello.model.stoneComponent.Stone

case class Field(matrix: Matrix[Stone]) extends FieldInterface {
  def this(size: Int, filling: Stone) = this(new Matrix(size, filling))
  val size = matrix.size
  val field1 = new Field(0, Stone.Empty)
  def bar(cellWidth: Int, cellNum: Int) = ""
  def cells(row: Int, cellWidth: Int) = ""
  def mesh(cellWidth: Int) = ""
  def get(x: Int, y: Int): Stone = Stone.Empty
  def put(stone: Stone, x: Int, y: Int): FieldInterface = copy(matrix.replaceCell(x, y, stone))
  def getSize(): Int = size
}