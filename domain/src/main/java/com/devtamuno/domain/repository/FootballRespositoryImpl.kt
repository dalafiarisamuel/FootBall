package com.devtamuno.domain.repository

import com.devtamuno.domain.data.AllCompetitions
import com.devtamuno.domain.data.AllTeamsInCompetition
import com.devtamuno.domain.data.Competition
import com.devtamuno.domain.data.CompetitionMatches
import com.devtamuno.domain.mapper.CompetitionMapper
import com.devtamuno.domain.mapper.response.AllCompetitionMapper
import com.devtamuno.domain.mapper.response.AllTeamsInCompetitionMapper
import com.devtamuno.domain.mapper.response.CompetitionMatchesMapper
import com.devtamuno.football.remote.repository.FootballRemoteRepository
import com.devtamuno.football.remote.repository.Resource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FootballRepositoryImpl @Inject constructor(
    private val remoteRepository: FootballRemoteRepository,
    private val allCompetitionMapper: AllCompetitionMapper,
    private val allTeamsInCompetitionMapper: AllTeamsInCompetitionMapper,
    private val competitionMapper: CompetitionMapper,
    private val competitionMatchesMapper: CompetitionMatchesMapper,
) : FootballRepository {
    override fun getAllCompetitions(): Flow<ResultState<AllCompetitions>> {
        return flow {
            when (val result = remoteRepository.getAllCompetitions()) {
                is Resource.Failure -> emit(ResultState.Failure(result.message))
                is Resource.Success -> emit(ResultState.Success(allCompetitionMapper(result.result)))
            }

        }
    }

    override fun getTeamsInCompetition(competitionId: Int): Flow<ResultState<AllTeamsInCompetition>> {
        return flow {
            when (val result = remoteRepository.getTeamsInCompetition(competitionId)) {
                is Resource.Failure -> emit(ResultState.Failure(result.message))
                is Resource.Success -> emit(ResultState.Success(allTeamsInCompetitionMapper(result.result)))
            }
        }
    }

    override fun getCompetition(competitionCode: String): Flow<ResultState<Competition>> {
        return flow {
            when (val result = remoteRepository.getCompetition(competitionCode)) {
                is Resource.Failure -> emit(ResultState.Failure(result.message))
                is Resource.Success -> emit(ResultState.Success(competitionMapper(result.result)))
            }
        }
    }

    override fun getAllMatchesInCompetition(competitionCode: String): Flow<ResultState<CompetitionMatches>> {
        return flow {
            when (val result = remoteRepository.getAllMatchesInCompetition(competitionCode)) {
                is Resource.Failure -> emit(ResultState.Failure(result.message))
                is Resource.Success -> emit(ResultState.Success(competitionMatchesMapper(result.result)))
            }
        }
    }
}