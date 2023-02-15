package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.data.response.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.response.GetAllTeamsInCompetitionRemote
import com.devtamuno.football.remote.data.response.GetCompetitionMatchesRemote
import com.devtamuno.football.remote.data.response.GetCompetitionRemote

interface FootballRemoteRepository {

    suspend fun getAllCompetitions(): Resource<GetAllCompetitionRemote>

    suspend fun getTeamsInCompetition(competitionId: Int): Resource<GetAllTeamsInCompetitionRemote>

    suspend fun getCompetition(competitionCode: String): Resource<GetCompetitionRemote>

    suspend fun getAllMatchesInCompetition(competitionCode: String): Resource<GetCompetitionMatchesRemote>

    suspend fun getAllTeamsFixtures()

    suspend fun getCompetitionTimeTable()
}