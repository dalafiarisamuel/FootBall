package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Referee
import com.devtamuno.football.remote.data.RefereeRemote
import javax.inject.Inject

class RefereeMapper @Inject constructor() : (RefereeRemote) -> Referee {
    override fun invoke(refereeRemote: RefereeRemote): Referee {
        return with(refereeRemote) {
            Referee(
                id = id,
                name = name,
                type = type,
                nationality = nationality,
            )
        }
    }
}