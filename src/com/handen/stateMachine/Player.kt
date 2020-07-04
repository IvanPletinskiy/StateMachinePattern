package com.handen.stateMachine

import com.handen.stateMachine.states.ReadyState
import com.handen.stateMachine.states.State

class Player {
    var state: State = ReadyState(this)
    var isPlaying = false
    private val playlist = mutableListOf<String>()
    private var currentTrack = 0


    init {
        isPlaying = true
        for(i in 1..12) {
            playlist += "Track $i"
        }
    }

    fun changeState(state: State) {
        this.state = state
    }

    fun startPlayback() = "Playing ${playlist[currentTrack]}"

    fun nextTrack(): String {
        currentTrack = (currentTrack + 1) % (playlist.size)

        return "Playing ${playlist[currentTrack]}"
    }

    fun previousTrack(): String {
        currentTrack--
        if(currentTrack < 0) {
            currentTrack = playlist.size - 1
        }

        return "Playing ${playlist[currentTrack]}"
    }

    fun setCurrentTrackAfterStop() {
        currentTrack = 0
    }
}