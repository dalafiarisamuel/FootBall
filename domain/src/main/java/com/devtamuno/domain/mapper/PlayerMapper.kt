package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Player
import com.devtamuno.football.remote.data.PlayerRemote
import javax.inject.Inject

class PlayerMapper @Inject constructor() : (PlayerRemote) -> Player {
    override fun invoke(playerRemote: PlayerRemote): Player {
        return with(playerRemote) {
            Player(
                id = id,
                name = name,
                position = position,
                dateOfBirth = dateOfBirth,
                nationality = nationality,
            )
        }
    }
}