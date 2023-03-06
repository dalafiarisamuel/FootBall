package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Team
import com.devtamuno.football.remote.data.TeamRemote
import javax.inject.Inject

class TeamMapper @Inject constructor(
    private val competitionAreaMapper: CompetitionAreaMapper,
    private val coachMapper: CoachMapper,
    private val playerMapper: PlayerMapper,
    private val competitionMapper: CompetitionMapper,
) : (TeamRemote) -> Team {

    override fun invoke(teamRemote: TeamRemote): Team {

        return with(teamRemote) {
            Team(
                id = id,

                name = name,

                shortName = shortName,

                tla = tla,

                address = address,

                website = website,

                founded = founded,

                clubColors = clubColors,

                venue = venue,

                crest = crest,

                area = area?.let(competitionAreaMapper),

                coach = coach?.let(coachMapper),

                squad = squad?.map(playerMapper) ?: emptyList(),

                runningCompetitions = runningCompetitions?.map(competitionMapper) ?: emptyList()
            )
        }
    }
}