package com.devtamuno.football.remote.api

import com.devtamuno.football.remote.data.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.GetAllTeamsInCompetitionRemote
import com.devtamuno.football.remote.data.GetCompetitionRemote
import com.devtamuno.football.remote.repository.Resource
import retrofit2.http.GET
import retrofit2.http.Path

internal interface FootballService {

    @GET("competitions")
    suspend fun getAllCompetitions(): GetAllCompetitionRemote

    @GET("competitions/{competition_id}/teams")
    suspend fun getTeamsInCompetition(@Path("competitionId") teamCode: Int)
            : GetAllTeamsInCompetitionRemote

    @GET("competitions/{competition_code}")
    suspend fun getCompetition(@Path("competition_code") competitionCode: String): GetCompetitionRemote

    @GET("competitions/{competition_code}/matches")
    suspend fun getAllTeamsFixtures(@Path("competition_code") competitionCode: String)

    suspend fun getAllMatchesInCompetition()

    suspend fun getCompetitionTimeTable()
}