package de.htwg.se.othello

import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.othello.model.matrixComponent.Matrix
import org.scalatest.matchers.should.Matchers._

class MatrixSpec extends AnyWordSpec {
  "A Matrix is a tailor-made immutable data type that contains a two-dimentional Vector of something. A Matrix" when {
    "empty " should {
      "be created by using a dimention and a sample cell" in {
        val matrix = new Matrix[String](2, "W")
        matrix.size should be(2)
      }
      "for test purposes only be created with a Vector of Vectors" in {
        val testMatrix = Matrix(Vector(Vector("W")))
        testMatrix.size should be(1)
      }

    }
    "filled" should {
      val matrix = new Matrix[String](2, "W")
      "give access to its cells" in {
        matrix.cell(0, 0) should be("W")
      }
      "replace cells and return a new data structure" in {
        val returnedMatrix = matrix.replaceCell(0, 0, "B")
        matrix.cell(0, 0) should be("W")
        returnedMatrix.cell(0, 0) should be("B")
      }
      "be filled using fill operation" in {
        val returnedMatrix = matrix.fill("W")
        returnedMatrix.cell(0, 0) should be("W")
      }
    }
  }

}
