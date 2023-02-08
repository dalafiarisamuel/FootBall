package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.data.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.Resource

interface FootballRemoteRepository {

    suspend fun getAllCompetitions(): Resource<GetAllCompetitionRemote>

    suspend fun getTeamsInCompetition(teamCode: String)

    suspend fun getAllTeamsFixtures()

    suspend fun getAllMatchesInCompetition()

    suspend fun getCompetitionTimeTable()
}