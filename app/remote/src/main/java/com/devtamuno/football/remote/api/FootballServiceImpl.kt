package com.devtamuno.football.remote.api

import io.ktor.client.HttpClient

internal class FootballServiceImpl(val client: HttpClient) : FootballService {
    override suspend fun getAllCompetitions() {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamsInCompetition(teamCode: String) {
        TODO("Not yet implemented")
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