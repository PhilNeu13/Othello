package de.htwg.se.othello
package util

trait Observer:
  def update(e: Event): Unit

trait Observable {
  var viewer: Vector[Observer] = Vector()
  def add(s: Observer) = viewer = viewer :+ s
  def remove(s: Observer) = viewer = viewer.filterNot(o => o == s)
  def notifyObservers(e: Event) = viewer.foreach(o => o.update(e))
}

enum Event:
  case Quit
  case Move
