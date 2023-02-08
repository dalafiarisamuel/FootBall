package com.devtamuno.football.remote.api

import com.devtamuno.football.remote.data.GetAllCompetitionRemote
import retrofit2.http.GET

internal interface FootballService {

    @GET("competitions")
    suspend fun getAllCompetitions(): GetAllCompetitionRemote

    suspend fun getTeamsInCompetition(teamCode: String)

    suspend fun getAllTeamsFixtures()

    suspend fun getAllMatchesInCompetition()

    suspend fun getCompetitionTimeTable()
}