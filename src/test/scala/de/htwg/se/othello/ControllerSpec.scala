package de.htwg.se.othello

package controller

import model.fieldComponent.Field
import model.MoveCoordinates
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.othello.model.stoneComponent._

import util.{Observer, Event}
import de.htwg.se.othello.model.playerComponent.PlayerQueue

class ControllerSpec extends AnyWordSpec {
  "The Controller" should {

    val controller = Controller(new Field(3, Stone.Empty), new PlayerQueue())

    val player1 = controller.addFirstPlayer("Phil")
    player1.toString() should be("Phil has Stone B")

    val player2 = controller.addSecondPlayer("Lukas")
    player2.toString() should be("Lukas has Stone W")

    "put a stone on the field when a move is made" in {
      val fieldWithMove = controller.put(MoveCoordinates(Stone.B, 1, 2))
      fieldWithMove.get(1, 2) should be(Stone.B)
      fieldWithMove.get(0, 0) should be(Stone.Empty)
    }

    "not put a stone on the field if this move was already made" in {
      var fieldWrongMove = controller.put(MoveCoordinates(Stone.B, 0, 0))
      fieldWrongMove = controller.put(MoveCoordinates(Stone.W, 0, 0))
      fieldWrongMove.get(0, 0) should be(Stone.W)
    }

    "notify its observers on change" in {
      class TestObserver(controller: Controller) extends Observer:
        controller.add(this)
        var test = false
        def update(e: Event) = test = true
      val testObserver = TestObserver(controller)
      testObserver.test should be(false)
      controller.doAndNotify(controller.put, MoveCoordinates(Stone.B, 1, 2))
      testObserver.test should be(true)
    }

    "undo and redo a move" in {
      var field = controller.field
      field = controller.put(MoveCoordinates(Stone.B, 1, 2))
      field.get(1, 2) should be(Stone.B)
      field = controller.undo
      field.get(1, 2) should be(Stone.Empty)
      field = controller.redo
      field.get(1, 2) should be(Stone.B)
    }

    controller.doAndNotify(controller.undo)
    controller.doAndNotify(controller.redo)
    controller.quit
  }
}
