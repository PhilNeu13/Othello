package de.htwg.se.othello.model

case class Field(matrix: Matrix[Stone]):
  
  def this(size: Int, filling: Stone) = this(new Matrix(size, filling))

  val size = matrix.size
  val eol = sys.props("line.separator")

  def bar(cellWidth: Int = 3, cellNum: Int = 3) =
    (("+" + "-" * cellWidth) * cellNum) + "+" + eol

  def cells(row: Int, cellWidth: Int = 3) =
    matrix
      .row(row)
      .map(_.toString)
      .map(" " * ((cellWidth - 1) / 2) + _ + " " * ((cellWidth - 1) / 2))
      .mkString("|", "|", "|") + eol
      
  def mesh(cellWidth: Int = 3) =
    (0 until size)
      .map(cells(_, cellWidth))
      .mkString(
        bar(cellWidth, size),
        bar(cellWidth, size),
        bar(cellWidth, size)
      )

<<<<<<< Updated upstream
  override def toString = mesh()
  
  def put(stone: Stone, x: Int, y: Int) = copy(matrix.replaceCell(x, y, stone))
=======
  def delete(x: Int, y: Int) = put(Stone.Empty,x,y)

  def isAllowed(x: Int, y: Int): Boolean = (x min y) >= 0 && (x max y) < 8
  
  def isFull(x: Int, y: Int): Boolean = isAllowed(x,y) && (get(x,y) == Stone.B || get(x,y) == Stone.W)
  
  def isFree(x: Int, y: Int): Boolean = isAllowed(x,y) && get(x,y) == Stone.Empty

  override def toString = mesh()

  def put(stone: Stone, x: Int, y: Int) = copy(matrix.replaceCell(x, y, stone))

  def get(x: Int, y: Int): Stone = matrix.cell(x, y) // Test purposes+
>>>>>>> Stashed changes
