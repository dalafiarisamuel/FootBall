package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.api.FootballService
import com.devtamuno.football.remote.data.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.GetAllTeamsInCompetitionRemote

internal class FootballRemoteRepositoryImpl(private val service: FootballService) :
    FootballRemoteRepository {
    override suspend fun getAllCompetitions(): Resource<GetAllCompetitionRemote> {
        return resourceHelper { service.getAllCompetitions() }
    }

    override suspend fun getTeamsInCompetition(competitionId: Int)
            : Resource<GetAllTeamsInCompetitionRemote> {
        return resourceHelper { service.getTeamsInCompetition(competitionId) }
    }

    override suspend fun getAllTeamsFixtures() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllMatchesInCompetition() {
        TODO("Not yet implemented")
    }

    override suspend fun getCompetitionTimeTable() {
        TODO("Not yet implemented")
    }
}