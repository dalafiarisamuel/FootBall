package com.devtamuno.domain.mapper.response

import com.devtamuno.domain.data.AllCompetitions
import com.devtamuno.football.remote.data.response.GetAllCompetitionRemote
import com.devtamuno.domain.mapper.CompetitionMapper
import javax.inject.Inject

class AllCompetitionMapper @Inject constructor(
    private val competitionMapper: CompetitionMapper
) : (GetAllCompetitionRemote) -> AllCompetitions {
    override fun invoke(getAllCompetitionRemote: GetAllCompetitionRemote): AllCompetitions {
        return with(getAllCompetitionRemote) {
            AllCompetitions(
                count = count,
                competitions = competitions.map(competitionMapper)
            )
        }
    }
}