package com.handen.stateMachine.states

import com.handen.stateMachine.Player


/**
 * Общий интерфейс всех состояний
 */
abstract class State(val player: Player) {

    abstract fun onLock(): String
    abstract fun onPlay(): String
    abstract fun onNext(): String
    abstract fun onPrevious(): String
}