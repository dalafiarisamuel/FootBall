package com.devtamuno.football.remote.api

import com.devtamuno.football.remote.utils.JsonParser.jsonConfig
import com.devtamuno.football.remote.utils.JsonParser.jsonStringFromFile
import com.google.common.truth.Truth.assertThat
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.internal.http.HttpMethod
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class, ExperimentalCoroutinesApi::class)
class FootballServiceTest {

    private lateinit var service: FootballService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url("")) //leave url empty, otherwise it'll attempt to make a network call
            .addConverterFactory(jsonConfig.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(FootballService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }


    @Test
    fun `get all competitions returns a success response and a valid body`() = runTest {
        enqueueMockResponse("competitions.json")
        val response = service.getAllCompetitions()
        val request = server.takeRequest()

        assertThat(request.path).isEqualTo("/competitions")
        assertThat(response).isNotNull()
        assertThat(response.competitions).isNotEmpty()
    }

    @Test
    fun `get competition by code returns a success response and a valid body`() = runTest {
        enqueueMockResponse("competition.json")
        val response = service.getCompetition(competitionCode = "PL")
        val request = server.takeRequest()

        assertThat(request.path).isEqualTo("/competitions/PL")
        assertThat(response).isNotNull()
        assertThat(response.code).isEqualTo("PL")
    }

    @Test
    fun `get teams in competition returns a success response and a valid body`() = runTest {
        enqueueMockResponse("teams_in_competition.json")
        val response = service.getTeamsInCompetition(competitionId = 2016)
        val request = server.takeRequest()

        assertThat(request.path).isEqualTo("/competitions/2016/teams")
        assertThat(response).isNotNull()
        assertThat(response.competition.id).isEqualTo(2016)
        assertThat(response.teams).isNotEmpty()

        HttpMethod
    }

    @Test
    fun `get matches in competition returns a success response and a valid body`() = runTest {
        enqueueMockResponse("matches_in_competition.json")
        val response = service.getAllMatchesInCompetition(competitionCode = "PL")
        val request = server.takeRequest()

        assertThat(request.path).isEqualTo("/competitions/PL/matches")
        assertThat(response).isNotNull()
        assertThat(response.competition.code).isEqualTo("PL")
        assertThat(response.matches).isNotEmpty()
    }


    private fun enqueueMockResponse(fileName: String) {
        val source = jsonStringFromFile(fileName)
        val mockResponse = MockResponse()
        mockResponse.setBody(source)
        server.enqueue(mockResponse)
    }
}