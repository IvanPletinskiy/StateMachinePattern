package com.handen.stateMachine.states

import com.handen.stateMachine.Player

class ReadyState(player: Player): State(player) {

    override fun onLock(): String {
        player.changeState(LockedState(player))
        return "Locked"
    }

    override fun onPlay(): String {
        val action = player.startPlayback()
        player.changeState(PlayingState(player))
        return action
    }

    override fun onNext() = "Locked"

    override fun onPrevious() = "Locked"
}