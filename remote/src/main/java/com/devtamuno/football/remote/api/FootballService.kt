package com.devtamuno.football.remote.api

import com.devtamuno.football.remote.data.response.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.response.GetAllTeamsInCompetitionRemote
import com.devtamuno.football.remote.data.response.GetCompetitionMatchesRemote
import com.devtamuno.football.remote.data.response.GetCompetitionRemote
import retrofit2.http.GET
import retrofit2.http.Path

internal interface FootballService {

    @GET("competitions")
    suspend fun getAllCompetitions(): GetAllCompetitionRemote

    @GET("competitions/{competition_id}/teams")
    suspend fun getTeamsInCompetition(@Path("competitionId") competitionId: Int)
            : GetAllTeamsInCompetitionRemote

    @GET("competitions/{competition_code}")
    suspend fun getCompetition(@Path("competition_code") competitionCode: String): GetCompetitionRemote

    @GET("competitions/{competition_code}/matches")
    suspend fun getAllMatchesInCompetition(@Path("competition_code") competitionCode: String): GetCompetitionMatchesRemote

    suspend fun getAllTeamsFixtures()

    suspend fun getCompetitionTimeTable()
}