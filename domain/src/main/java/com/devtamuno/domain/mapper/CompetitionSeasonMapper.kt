package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.CompetitionSeason
import com.devtamuno.football.remote.data.CompetitionSeasonRemote
import javax.inject.Inject

class CompetitionSeasonMapper @Inject constructor(private val winnerMapper: WinnerMapper) :
        (CompetitionSeasonRemote) -> CompetitionSeason {

    override fun invoke(competitionSeasonRemote: CompetitionSeasonRemote): CompetitionSeason {
        return with(competitionSeasonRemote) {
            CompetitionSeason(
                id = id,

                startDate = startDate,

                endDate = endDate,

                currentMatchDay = currentMatchDay,

                winner = winner?.let { winnerMapper(it) }
            )
        }
    }
}