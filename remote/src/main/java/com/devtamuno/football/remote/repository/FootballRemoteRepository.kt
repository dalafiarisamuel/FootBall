package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.data.CompetitionRemote
import com.devtamuno.football.remote.data.response.GetAllCompetitionRemote
import com.devtamuno.football.remote.data.response.GetAllTeamsInCompetitionRemote
import com.devtamuno.football.remote.data.response.GetCompetitionMatchesRemote

interface FootballRemoteRepository {

    suspend fun getAllCompetitions(): Resource<GetAllCompetitionRemote>

    suspend fun getTeamsInCompetition(competitionId: Int): Resource<GetAllTeamsInCompetitionRemote>

    suspend fun getCompetition(competitionCode: String): Resource<CompetitionRemote>

    suspend fun getAllMatchesInCompetition(competitionCode: String): Resource<GetCompetitionMatchesRemote>
}