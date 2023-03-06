package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Coach
import com.devtamuno.football.remote.data.CoachRemote
import javax.inject.Inject

class CoachMapper @Inject constructor() : (CoachRemote) -> Coach {
    override fun invoke(coachRemote: CoachRemote): Coach {
        return with(coachRemote) {
            Coach(
                id, firstName, lastName, name, dateOfBirth, nationality
            )
        }
    }
}