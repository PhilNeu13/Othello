package de.htwg.se.othello.model.fileIOComponent.fileIOjsonimpl

import de.htwg.se.othello.Config
import de.htwg.se.othello.model.fileIOComponent.FileIOInterface
import de.htwg.se.othello.model.fieldComponent.FieldInterface
import de.htwg.se.othello.model.fieldComponent._
import de.htwg.se.othello.model.Stone
import play.api.libs.json._
import scala.io.Source

class FileIO extends FileIOInterface {

  override def load: FieldInterface = {
    val source: String = Source.fromFile("field.json").getLines.mkString
    val json: JsValue = Json.parse(source)
    val size = (json \ "field" \ "size").get.toString.toInt
    var field: FieldInterface = new Field(size, Stone.Empty)

    for ((index) <- 0 until (size - 1) * (size - 1)) {
      val row = (json \\ "row")(index).as[Int]
      val col = (json \\ "col")(index).as[Int]
      val value = (json \\ "cell")(index).as[String]
      value match {
        case " " => field = field.put(Stone.Empty, row, col)
        case "B" => field = field.put(Stone.B, row, col)
        case "W" => field = field.put(Stone.W, row, col)
        case _ =>
      }
    }
    field
  }

  override def save(field: FieldInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("field.json"))
    pw.write(Json.prettyPrint(fieldToJson(field)))
    pw.close
  }

  def fieldToJson(field: FieldInterface) = {
    Json.obj(
      "field" -> Json.obj(
        "size" -> JsNumber(field.getSize()),
        "cells" -> Json.toJson(
          for {
            row <- 0 until field.getSize()
            col <- 0 until field.getSize()
          } yield {
            Json.obj(
              "row" -> row,
              "col" -> col,
              "cell" -> field.get(row, col).toString
            )
          }
        )
      )
    )
  }
}