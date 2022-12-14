package de.htwg.se.othello.model.fieldComponent

import de.htwg.se.othello.model.fieldComponent.fieldBuilderMockImpl.FieldBuilder

trait FieldBuilderInterface {

    def createEmptyField(): FieldBuilderInterface
    def createOthelloField(): FieldBuilderInterface
}
