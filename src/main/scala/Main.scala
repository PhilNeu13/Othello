import scala.io.StdIn._

@main def Othello: Unit =
  println("Welcome to Othello!")
  println(mesh(cellNum = 1))

val eol = sys.props("line.separator")
def bar(cellwidth: Int = 3, cellNum: Int = 5) =
  ("+" + "-" * cellwidth) * cellNum + "+" + eol
def cells(cellwidth: Int = 3, cellNum: Int = 5) =
  ("|" + " " * cellwidth) * cellNum + "|" + eol
def mesh(cellwidth: Int = 3, cellNum: Int = 1) =
  (bar(cellwidth, cellNum) + cells(cellwidth, cellNum)) * cellNum + bar(
    cellwidth,
    cellNum
  )
def startGame(): Array[String] = {
  println("Name Player 1: ")
  val name1 = readLine()
  print("Name Player 2: ")
  val name2 = readLine()
  if (names(0) == null || names(1) == null) {
    throw new Exception("2 Players are required!")
  }
  val names = Array(name1, name2)
  names
}
def askForMove(player: Int, names: Array[String]): Array[Int] = {
  println(names(player - 1) + "ist an der Reihe")
  println("x eingeben:")
  val x = readInt()
  println("y eingeben:")
  val y = readInt()
  val move = Array(x, y)
  move
}
def isPossible(arr: Array[Array[Int]], x: Int, y: Int, player: Int): Boolean = {
  if (x <= arr.length || y <= arr(0).length) {
    true
  } else {
    false
  }
}
def makeMove(
    arr: Array[Array[Int]],
    x: Int,
    y: Int,
    player: Int
): Array[Array[Int]] = {}
def printNewField(arr: Array[Array[Int]], cellwidth: Int): String = {}
