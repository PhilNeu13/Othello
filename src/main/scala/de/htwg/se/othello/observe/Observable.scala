package de.htwg.se.othello.observe

trait Observable {
  var viewer: Vector[Observer] = Vector()
  def add(s: Observer) = viewer = viewer :+ s
  def remove(s: Observer) = viewer = viewer.filterNot(o => o == s)
  def notifyObservers = viewer.foreach(o => o.update)
}