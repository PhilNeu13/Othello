package de.htwg.se.othello.controller
import de.htwg.se.othello.model.MoveCoordinates
import de.htwg.se.othello.model.fieldComponent.Field
import de.htwg.se.othello.util.Command

class CmdController(move: MoveCoordinates) extends Command[Field] {

  var undoList: Option[Field] = None
  var redoList: Option[Field] = None

  override def doStep(field: Field): Field =
    undoList = Some(field)
    field.put(move.stone, move.x, move.y)

  override def redoStep(field: Field): Field =
    undoList = Some(field)
    redoList.get

  override def undoStep(field: Field): Field =
    redoList = Some(field)
    undoList.get
}
