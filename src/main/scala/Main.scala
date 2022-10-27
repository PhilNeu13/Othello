@main def Othello: Unit = 
  println("Welcome to Othello!")
  println(mesh(cellNum = 8))


val eol = sys.props("line.separator")
def bar(cellwidth: Int = 3, cellNum: Int = 5) = ("+" + "-" * cellwidth) * cellNum + "+" + eol
def cells(cellwidth: Int = 3, cellNum: Int = 5) = ("|" + " " * cellwidth) * cellNum + "|" + eol
def mesh(cellwidth: Int = 3, cellNum: Int = 1) = (bar(cellwidth, cellNum) + cells(cellwidth, cellNum)) * cellNum + bar(cellwidth, cellNum)
