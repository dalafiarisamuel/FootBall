package com.devtamuno.domain.mapper.response

import com.devtamuno.domain.data.AllTeamsInCompetition
import com.devtamuno.football.remote.data.response.GetAllTeamsInCompetitionRemote
import com.devtamuno.domain.mapper.CompetitionMapper
import com.devtamuno.domain.mapper.CompetitionSeasonMapper
import com.devtamuno.domain.mapper.TeamMapper
import javax.inject.Inject

class AllTeamsInCompetitionMapper @Inject constructor(
    private val competitionMapper: CompetitionMapper,
    private val competitionSeasonMapper: CompetitionSeasonMapper,
    private val teamMapper: TeamMapper
) : (GetAllTeamsInCompetitionRemote) -> AllTeamsInCompetition {

    override fun invoke(allTeamInCompetionRemote: GetAllTeamsInCompetitionRemote): AllTeamsInCompetition {
        return with(allTeamInCompetionRemote) {
            AllTeamsInCompetition(
                competition = competitionMapper(competition),
                season = competitionSeasonMapper(season),
                teams = teams.map(teamMapper),
            )
        }
    }

}