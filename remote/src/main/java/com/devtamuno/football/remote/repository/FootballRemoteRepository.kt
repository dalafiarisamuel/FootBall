package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.data.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.GetAllTeamsInCompetitionRemote

interface FootballRemoteRepository {

    suspend fun getAllCompetitions(): Resource<GetAllCompetitionRemote>

    suspend fun getTeamsInCompetition(competitionId: Int): Resource<GetAllTeamsInCompetitionRemote>

    suspend fun getAllTeamsFixtures()

    suspend fun getAllMatchesInCompetition()

    suspend fun getCompetitionTimeTable()
}