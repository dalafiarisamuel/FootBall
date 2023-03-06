package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.api.FootballService
import com.devtamuno.football.remote.data.CompetitionRemote
import com.devtamuno.football.remote.data.response.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.response.GetAllTeamsInCompetitionRemote
import com.devtamuno.football.remote.data.response.GetCompetitionMatchesRemote

internal class FootballRemoteRepositoryImpl(private val service: FootballService) :
    FootballRemoteRepository {
    override suspend fun getAllCompetitions(): Resource<GetAllCompetitionRemote> {
        return resourceHelper { service.getAllCompetitions() }
    }

    override suspend fun getTeamsInCompetition(competitionId: Int)
            : Resource<GetAllTeamsInCompetitionRemote> {
        return resourceHelper { service.getTeamsInCompetition(competitionId) }
    }

    override suspend fun getCompetition(competitionCode: String): Resource<CompetitionRemote> {
        return resourceHelper { service.getCompetition(competitionCode) }
    }

    override suspend fun getAllMatchesInCompetition(competitionCode: String)
            : Resource<GetCompetitionMatchesRemote> {
        return resourceHelper { service.getAllMatchesInCompetition(competitionCode) }
    }

}