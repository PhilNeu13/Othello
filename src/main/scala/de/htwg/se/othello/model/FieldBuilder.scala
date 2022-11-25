package de.htwg.se.othello.model

class FieldBuilder(size: Int, filling: Stone) {

<<<<<<< HEAD
  val maxRange = 8

  val middle = (size / 2) - 1

  val middleOffset = middle + 1

  def createEmptyField(): Field =
    val field2 = new Field(size, Stone.Empty)
    field2

  def createOthelloField(): Field =
    createEmptyField()
      .put(Stone.W, middle, middle)
      .put(Stone.B, middleOffset, middle)
      .put(Stone.W, middleOffset, middleOffset)
      .put(Stone.B, middle, middleOffset)

=======
    val maxRange = 8

    val middle = (size/2)-1

    val middleOffset = middle + 1

    def createEmptyField() : Field =
        val field2 = new Field(size, Stone.Empty)
        field2


    def createOthelloField() : Field = 
        createEmptyField().put(Stone.W,middle,middle).put(Stone.B,middleOffset,middle).put(Stone.W,middleOffset,middleOffset).put(Stone.B,middle,middleOffset)


    
>>>>>>> 6cc056d0aa64d760bcba8ec77628f029bed0764c
}
