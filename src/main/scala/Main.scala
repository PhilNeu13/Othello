@main def Othello: Unit = 
  println("Welcome to Othello!")
  println(mesh)


val eol = sys.props("line.separator")
def bar(cellwidth: Int = 3, cellNum: Int = 5) = ("+" + "-" * cellwidth) * cellNum + "+" + eol
def cells(cellwidth: Int = 3, cellNum: Int = 5) = ("|" + " " * cellwidth) * cellNum + "|" + eol
val mesh = (bar() + cells()) * 5 + bar()
