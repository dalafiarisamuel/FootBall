package com.devtamuno.football.remote.api

import com.devtamuno.football.remote.utils.MockOkHttpServer
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FootballServiceTest {

    private lateinit var service: FootballService
    private lateinit var server: MockOkHttpServer<FootballService>

    @Before
    fun setUp() {
        server = MockOkHttpServer(FootballService::class.java)
        service = server.getPreparedService()
    }

    @After
    fun tearDown() {
        server.shotDownServer()
    }


    @Test
    fun `get all competitions returns a success response and a valid body`() = runTest {
        server.enqueueJsonMockResponse("competitions.json")
        val response = service.getAllCompetitions()

        assertThat(server.getRequestPath()).isEqualTo("/competitions")
        assertThat(response).isNotNull()
        assertThat(response.competitions).isNotEmpty()
    }

    @Test
    fun `get competition by code returns a success response and a valid body`() = runTest {
        server.enqueueJsonMockResponse("competition.json")
        val response = service.getCompetition(competitionCode = "PL")

        assertThat(server.getRequestPath()).isEqualTo("/competitions/PL")
        assertThat(response).isNotNull()
        assertThat(response.code).isEqualTo("PL")
    }

    @Test
    fun `get teams in competition returns a success response and a valid body`() = runTest {
        server.enqueueJsonMockResponse("teams_in_competition.json")
        val response = service.getTeamsInCompetition(competitionId = 2016)

        assertThat(server.getRequestPath()).isEqualTo("/competitions/2016/teams")
        assertThat(response).isNotNull()
        assertThat(response.competition.id).isEqualTo(2016)
        assertThat(response.teams).isNotEmpty()
    }

    @Test
    fun `get matches in competition returns a success response and a valid body`() = runTest {
        server.enqueueJsonMockResponse("matches_in_competition.json")
        val response = service.getAllMatchesInCompetition(competitionCode = "PL")

        assertThat(server.getRequestPath()).isEqualTo("/competitions/PL/matches")
        assertThat(response).isNotNull()
        assertThat(response.competition.code).isEqualTo("PL")
        assertThat(response.matches).isNotEmpty()
    }
}