package de.htwg.se.othello.model.fieldComponent

import de.htwg.se.othello.model.fieldComponent.FieldInterface
import de.htwg.se.othello.model.stoneComponent.Stone

case class Field(matrix: Matrix[Stone]) extends FieldInterface:
  def this(size: Int, filling: Stone) = this(new Matrix(size, filling))
  val size = matrix.size
  val eol = sys.props("line.separator")
  def bar(cellWidth: Int = 3, cellNum: Int = 3) =
    (("+" + "-" * cellWidth) * cellNum) + "+" + eol
  def cells(row: Int, cellWidth: Int = 3) =
    matrix
      .row(row)
      .map(_.toString)
      .map(" " * ((cellWidth - 1) / 2) + _ + " " * ((cellWidth - 1) / 2))
      .mkString("|", "|", "|") + eol
  def mesh(cellWidth: Int = 3) =
    (0 until size)
      .map(cells(_, cellWidth))
      .mkString(
        bar(cellWidth, size),
        bar(cellWidth, size),
        bar(cellWidth, size)
      )
  override def toString = mesh()
  def put(stone: Stone, x: Int, y: Int) = copy(matrix.replaceCell(x, y, stone))

  def get(x: Int, y: Int): Stone = matrix.cell(x, y)
  def getSize(): Int = size
