package com.devtamuno.domain.mapper.response

import com.devtamuno.domain.data.CompetitionMatches
import com.devtamuno.football.remote.data.response.GetCompetitionMatchesRemote
import com.devtamuno.domain.mapper.CompetitionMapper
import com.devtamuno.domain.mapper.FiltersMapper
import com.devtamuno.domain.mapper.MatchMapper
import com.devtamuno.domain.mapper.ResultSetMapper
import javax.inject.Inject

class CompetitionMatchesMapper @Inject constructor(
    private val filtersMapper: FiltersMapper,
    private val resultSetMapper: ResultSetMapper,
    private val matchMapper: MatchMapper,
    private val competitionMapper: CompetitionMapper,
) : (GetCompetitionMatchesRemote) -> CompetitionMatches {

    override fun invoke(getCompetitionMatchesRemote: GetCompetitionMatchesRemote): CompetitionMatches {
        return with(getCompetitionMatchesRemote) {
            CompetitionMatches(
                filters = filtersMapper(filters),
                resultSet = resultSetMapper(resultSet),
                competition = competitionMapper(competition),
                matches = matches.map(matchMapper)
            )
        }
    }
}