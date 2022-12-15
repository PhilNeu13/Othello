package de.htwg.se.othello.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import de.htwg.se.othello.model.fieldComponent._
import de.htwg.se.othello.model.stoneComponent._

class FieldBuilderSpec extends AnyWordSpec {

  "The FieldBuilder" when {

    "middle" should {
      val fieldBuilder = new FieldBuilder(4, Stone.Empty)
      "have middle" in {
        fieldBuilder.middle should be(1)
      }
    }
    "middleoffset" should {
      val fieldBuilder = new FieldBuilder(4, Stone.Empty)
      "have middleoffset" in {
        fieldBuilder.middleOffset should be(2)
      }
    }
    "createEmptyField" should {
      val fieldBuilder = new FieldBuilder(3, Stone.Empty)
      "have nothing in it" in {
        fieldBuilder.createEmptyField().toString() should be(("""#+---+---+---+
          #|   |   |   |
          #+---+---+---+
          #|   |   |   |
          #+---+---+---+
          #|   |   |   |
          #+---+---+---+
          #""").stripMargin('#'))
      }
    }
    "createOthelloField" should {
      val fieldBuilder = new FieldBuilder(3, Stone.Empty)
      "have othello field" in {
        fieldBuilder.createOthelloField().toString() should be(
          ("""#+---+---+---+
          #| W | B |   |
          #+---+---+---+
          #| B | W |   |
          #+---+---+---+
          #|   |   |   |
          #+---+---+---+
          #""").stripMargin('#')
        )
      }
    }
  }
}
