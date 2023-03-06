package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Competition
import com.devtamuno.football.remote.data.CompetitionRemote
import javax.inject.Inject

class CompetitionMapper @Inject constructor(
    private val competitionAreaMapper: CompetitionAreaMapper,
    private val competitionSeasonMapper: CompetitionSeasonMapper,
) : (CompetitionRemote) -> Competition {

    override fun invoke(competitionRemote: CompetitionRemote): Competition {
        return with(competitionRemote) {
            Competition(
                id = id,

                name = name,

                code = code,

                type = type,

                emblem = emblem,

                area = area?.let { competitionAreaMapper(it) },

                currentSeason = currentSeason?.let { competitionSeasonMapper(it) },

                seasons = seasons?.map(competitionSeasonMapper) ?: emptyList(),

                numberOfAvailableSeason = numberOfAvailableSeason,

                lastUpdated = lastUpdated,
            )
        }
    }
}