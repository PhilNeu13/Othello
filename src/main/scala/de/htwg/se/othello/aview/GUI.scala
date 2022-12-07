package de.htwg.se.othello
package aview

import controller._
import model._
import util._
import util.Event

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
    contents += new Menu("File") {
      contents += new MenuItem(Action("Exit") {
        sys.exit(0)
      })
    }
    contents += new MenuItem(Action("Undo") {
      controller.doAndNotify(controller.undo)
    })
    contents += new MenuItem(Action("Redo") {
      controller.doAndNotify(controller.redo)
    })
  }
  contents = new BorderPanel {
    add(
      new CellPanel(controller.field.size, controller.field.size),
      BorderPanel.Position.Center
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
          new CellPanel(controller.field.size, controller.field.size),
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
