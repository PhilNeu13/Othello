package de.htwg.se.othello.model
import de.htwg.se.othello.model.stoneComponent._
import de.htwg.se.othello.model.fieldComponent._

trait FieldInterface:
  val size: Int
  val eol: String
  def bar(cellWidth: Int, row: Int): String
  def cells(row: Int, cellWidth: Int): String
  def put(stone: Stone, x: Int, y: Int): Field
  def get(x: Int, y: Int): Stone