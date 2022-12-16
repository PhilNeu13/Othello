package de.htwg.se.othello
package aview

import controller.controllerComponent._
import model._
import util._
import util.Event
import model.Stone

import scala.language.postfixOps
import scala.swing._
import scala.swing.event._

class GUI(controller: Controller, playerQ: PlayerQueue)
    extends Frame
    with UI(controller):
  override def controllMove: Unit = None

  override def makeAMove(input: String): Option[MoveCoordinates] = None

  title = "Othello"
  menuBar = new MenuBar {
    contents += new MenuItem(Action("Exit") {
      controller.quit
    })
    contents += new MenuItem(Action("Undo") {
      controller.doAndNotify(controller.undo)
    })
    contents += new MenuItem(Action("Redo") {
      controller.doAndNotify(controller.redo)
    })
  }
  contents = new BorderPanel {
    add(
      new CellPanel(controller.field.getSize(), controller.field.getSize()),
      BorderPanel.Position.Center
    )
    add(
      new Label(
        "It's Player " + playerQ.currentState.getStone().toString + "'s turn!"
      ),
      BorderPanel.Position.North
    )
  }
  pack()
  centerOnScreen()
  open()

  def update(e: Event): Unit = e match
    case Event.Quit => this.dispose
    case Event.Move =>
      contents = new BorderPanel {
        add(
          new Label(
            "It's Player " + playerQ.currentState
              .getStone()
              .toString + "'s turn!"
          ),
          BorderPanel.Position.North
        )
        add(
          new CellPanel(controller.field.getSize(), controller.field.getSize()),
          BorderPanel.Position.Center
        )
      }
      repaint

  class CellPanel(r: Int, c: Int) extends GridPanel(r, c):
    var list: List[CellButton] = List()
    for (i <- 0 to r - 1; j <- 0 to c - 1) {
      list = list :+ CellButton(i, j, controller.field.get(i, j).toString)
    }
    list.foreach(t => contents += t)

  case class CellButton(r: Int, c: Int, var stone: String)
      extends Button(stone):
    listenTo(mouse.clicks)
    reactions += {
      case MouseClicked(src, pt, mod, clicks, props) => {
        val stone = playerQ.currentState.getStone()
        controller.doAndNotify(controller.put, MoveCoordinates(stone, r, c))
      }
    }
