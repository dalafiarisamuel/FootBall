package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Winner
import com.devtamuno.football.remote.data.WinnerRemote
import javax.inject.Inject

class WinnerMapper @Inject constructor() : (WinnerRemote) -> Winner {

    override fun invoke(winnerRemote: WinnerRemote): Winner {
        return with(winnerRemote) {
            Winner(
                id = id,
                name = name,
                shortName = name,
                tla = tla,
                crest = crest,
                address = address,
                website = website,
                founded = founded,
                clubColors = clubColors,
                venue = venue,
                lastUpdated = lastUpdated
            )
        }
    }
}