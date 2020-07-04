package com.handen.stateMachine.states

import com.handen.stateMachine.Player

class LockedState(player: Player): State(player) {

    init {
        player.isPlaying = false
    }

    override fun onLock(): String {
        return if (player.isPlaying) {
            player.changeState(ReadyState(player))
            "Stop playing"
        } else {
            "Locked..."
        }
    }

    override fun onPlay(): String {
        player.changeState(ReadyState(player))
        return "Ready"
    }

    override fun onNext(): String {
        return "Locked"
    }

    override fun onPrevious(): String {
        return "Locked"
    }
}