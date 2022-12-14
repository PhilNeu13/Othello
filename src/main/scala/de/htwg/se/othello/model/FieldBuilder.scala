package de.htwg.se.othello.model

<<<<<<< Updated upstream:src/main/scala/de/htwg/se/othello/model/FieldBuilder.scala
class FieldBuilder(size: Int, filling: Stone) {
=======
import de.htwg.se.othello.model.fieldComponent.FieldBuilderInterface
import de.htwg.se.othello.model.stoneComponent.Stone

class FieldBuilder(size: Int, filling: Stone){
>>>>>>> Stashed changes:src/main/scala/de/htwg/se/othello/model/fieldComponent/FieldBuilder.scala
  val maxRange = 8

  val middle = (size / 2) - 1

  val middleOffset = middle + 1

  def createEmptyField(): FieldInterface =
    val field2 = new Field(size, Stone.Empty)
    field2

  def createOthelloField(): FieldInterface =
    createEmptyField()
      .put(Stone.W, middle, middle)
      .put(Stone.B, middleOffset, middle)
      .put(Stone.W, middleOffset, middleOffset)
      .put(Stone.B, middle, middleOffset)

}
