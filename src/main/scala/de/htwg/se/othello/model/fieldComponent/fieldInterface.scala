package de.htwg.se.othello.model.fieldComponent

import de.htwg.se.othello.model.stoneComponent.Stone

trait FieldInterface {

    def bar(cellWidth: Int, cellNum: Int): String
    def cells(row: Int, cellWidth: Int): String
    def mesh(cellWidth: Int): String
    def put(stone: Stone, x: Int, y: Int): FieldInterface
    def get(x: Int, y: Int): Stone
    def getSize() : Int
}
