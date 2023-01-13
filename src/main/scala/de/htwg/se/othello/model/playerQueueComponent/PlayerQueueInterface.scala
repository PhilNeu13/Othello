package de.htwg.se.othello.model.playerQueueComponent

trait PlayerQueueInterface {
    var black: State
    var white: State
    var currentState: State
    var prevState: State
    def changeState(): Unit
}