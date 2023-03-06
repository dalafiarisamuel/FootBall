package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Match
import com.devtamuno.football.remote.data.MatchRemote
import javax.inject.Inject

class MatchMapper @Inject constructor(
    private val competitionAreaMapper: CompetitionAreaMapper,
    private val competitionSeasonMapper: CompetitionSeasonMapper,
    private val competitionMapper: CompetitionMapper,
    private val teamMapper: TeamMapper,
    private val refereeMapper: RefereeMapper,
) : (MatchRemote) -> Match {

    override fun invoke(matchRemote: MatchRemote): Match {
        return with(matchRemote) {
            Match(
                id = id,

                utcDate = utcDate,

                status = status,

                matchDay = matchDay,

                stage = stage,

                lastUpdated = lastUpdated,

                area = competitionAreaMapper(area),

                competition = competitionMapper(competition),

                season = competitionSeasonMapper(season),

                homeTeam = teamMapper(homeTeam),

                awayTeam = teamMapper(awayTeam),

                referees = referees.map(refereeMapper)
            )
        }
    }
}