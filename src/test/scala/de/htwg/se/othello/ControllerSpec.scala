package de.htwg.se.othello

package controller

import model.{Field, MoveCoordinates, Stone}
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import observe.Observer

class ControllerSpec extends AnyWordSpec {
  "The Controller" should {
    val controller = Controller(new Field(3, Stone.Empty))
    "put a stone on the field when a move is made" in {
      val fieldWithMove = controller.put(MoveCoordinates(Stone.B, 1, 2))
      fieldWithMove.get(1, 2) should be(Stone.B)
      fieldWithMove.get(0, 0) should be(Stone.Empty)
    }
    "notify its observers on change" in {
      class TestObserver(controller: Controller) extends Observer:
        controller.add(this)
        var test = false
        def update = test = true
      val testObserver = TestObserver(controller)
      testObserver.test should be(false)
      controller.doAndNotify(controller.put, MoveCoordinates(Stone.B, 1, 2))
      testObserver.test should be(true)
    }
  }
}
