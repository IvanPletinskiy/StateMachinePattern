package com.handen.stateMachine.states

import com.handen.stateMachine.Player

class PlayingState(player: Player): State(player) {

    override fun onLock(): String {
        player.changeState(LockedState(player))
        player.setCurrentTrackAfterStop()
        return "Stop playing"
    }

    override fun onPlay(): String {
        player.changeState(ReadyState(player))
        return "Paused"
    }

    override fun onNext() = player.nextTrack()

    override fun onPrevious() = player.previousTrack()
}