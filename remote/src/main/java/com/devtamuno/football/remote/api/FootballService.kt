package com.devtamuno.football.remote.api

import com.devtamuno.football.remote.data.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.GetAllTeamsInCompetitionRemote
import retrofit2.http.GET
import retrofit2.http.Path

internal interface FootballService {

    @GET("competitions")
    suspend fun getAllCompetitions(): GetAllCompetitionRemote

    @GET("competitions/{competition_id}/teams")
    suspend fun getTeamsInCompetition(@Path("competitionId") teamCode: Int)
            : GetAllTeamsInCompetitionRemote

    suspend fun getAllTeamsFixtures()

    suspend fun getAllMatchesInCompetition()

    suspend fun getCompetitionTimeTable()
}