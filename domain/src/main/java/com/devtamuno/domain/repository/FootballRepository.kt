package com.devtamuno.domain.repository

import com.devtamuno.domain.data.AllCompetitions
import com.devtamuno.domain.data.AllTeamsInCompetition
import com.devtamuno.domain.data.Competition
import com.devtamuno.domain.data.CompetitionMatches
import kotlinx.coroutines.flow.Flow

interface FootballRepository {

    fun getAllCompetitions(): Flow<ResultState<AllCompetitions>>

    fun getTeamsInCompetition(competitionId: Int): Flow<ResultState<AllTeamsInCompetition>>

    fun getCompetition(competitionCode: String): Flow<ResultState<Competition>>

    fun getAllMatchesInCompetition(competitionCode: String): Flow<ResultState<CompetitionMatches>>
}