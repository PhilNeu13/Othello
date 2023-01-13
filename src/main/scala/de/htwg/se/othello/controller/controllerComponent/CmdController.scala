package de.htwg.se.othello.controller.controllerComponent
import de.htwg.se.othello.model.MoveCoordinates
import de.htwg.se.othello.model.fieldComponent.FieldInterface
import de.htwg.se.othello.util.Command

class CmdController(move: MoveCoordinates) extends Command[FieldInterface]{

  var undoList: Option[FieldInterface] = None
  var redoList: Option[FieldInterface] = None

  override def doStep(field: FieldInterface): FieldInterface =
    undoList = Some(field)
    field.put(move.stone, move.x, move.y)

  override def redoStep(field: FieldInterface): FieldInterface =
    undoList = Some(field)
    redoList.get

  override def undoStep(field: FieldInterface): FieldInterface =
    redoList = Some(field)
    undoList.get
}
