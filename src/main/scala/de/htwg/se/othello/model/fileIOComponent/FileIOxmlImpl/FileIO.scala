package de.htwg.se.othello.model.fileIOComponent.fileIOxmlimpl

import de.htwg.se.othello.Config
import de.htwg.se.othello.model.fileIOComponent.FileIOInterface
import de.htwg.se.othello.model.fieldComponent.FieldInterface
import de.htwg.se.othello.model.fieldComponent.Field
import de.htwg.se.othello.model.Stone
import de.htwg.se.othello.model.fieldComponent._
import scala.xml.{ NodeSeq, PrettyPrinter }


class FileIO extends FileIOInterface {

  override def load: FieldInterface = {
    val file = scala.xml.XML.loadFile("field.xml")
    val sizeAttr = (file \\ "field" \ "@size")
    val size = sizeAttr.text.toInt
    var field: FieldInterface = new Field(size, Stone.Empty)

    val cellNodes = (file \\ "cell")
    for (cell <- cellNodes) {
      val row: Int = (cell \ "@row").text.toInt
      val col: Int = (cell \ "@col").text.toInt
      val value: String = cell.text.trim.toString
      value match {
        case " " => field = field.put(Stone.Empty, row, col)
        case "B" => field = field.put(Stone.B, row, col)
        case "W" => field = field.put(Stone.W, row, col)
        case _ =>
      }
    }
    field
  }

  def save(field: FieldInterface): Unit = saveString(field)

  def saveXML(field: FieldInterface): Unit = {
    scala.xml.XML.save("field.xml", fieldToXml(field))
  }

  def saveString(field: FieldInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("field.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(fieldToXml(field))
    pw.write(xml)
    pw.close
  }
  def fieldToXml(field: FieldInterface) = {
    <field size={ field.getSize().toString }>
      {
      for {
        row <- 1 until field.getSize() 
        col <- 1 until field.getSize()
      } yield cellToXml(field, row, col)
      }
    </field>
  }

  def cellToXml(field: FieldInterface, row: Int, col: Int) = {
    <cell row={ row.toString } col={ col.toString }>
    { field.get(row, col).toString }
    </cell>
  }
}