package com.devtamuno.football.remote.api

internal interface FootballService {
    suspend fun getAllCompetitions()
    suspend fun getTeamsInCompetition(teamCode: String)
    suspend fun getAllTeamsFixtures()
    suspend fun getAllMatchesInCompetition()
    suspend fun getCompetitionTimeTable()
}