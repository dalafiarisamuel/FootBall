package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.api.FootballService
import com.devtamuno.football.remote.utils.JsonParser
import com.google.common.truth.Truth.assertThat
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class, ExperimentalCoroutinesApi::class)
class FootballRemoteRepositoryImplTest {

    private lateinit var service: FootballService
    private lateinit var server: MockWebServer
    private lateinit var footballRepository: FootballRemoteRepositoryImpl

    @Before
    fun setUp() {

        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url("")) //leave url empty, otherwise it'll attempt to make a network call
            .addConverterFactory(JsonParser.jsonConfig.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(FootballService::class.java)

        footballRepository = FootballRemoteRepositoryImpl(service)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `when get all competition is called with a success response`() = runTest {
        enqueueSuccessMockResponse("competitions.json")

        val result = footballRepository.getAllCompetitions()

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get all competition is called with an error json body`() = runTest {
        "error.json".enqueueErrorMockResponse()

        val result = footballRepository.getAllCompetitions()

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get all competition is called with an invalid body`() = runTest {
        "This is a malformed body".enqueueMalformedJsonErrorMockResponse()

        val result = footballRepository.getAllCompetitions()

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("HTTP 400 Client Error")
    }

    @Test
    fun `when get teams in competition is called with a success response`() = runTest {
        enqueueSuccessMockResponse("teams_in_competition.json")

        val result = footballRepository.getTeamsInCompetition(2016)

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get teams in competition is called with an error json body`() = runTest {
        "error.json".enqueueErrorMockResponse()

        val result = footballRepository.getTeamsInCompetition(2016)

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get teams in competition is called with an invalid body`() = runTest {
        "This is a malformed body".enqueueMalformedJsonErrorMockResponse()

        val result = footballRepository.getTeamsInCompetition(2016)

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("HTTP 400 Client Error")
    }

    @Test
    fun `when get competition is called with a success response`() = runTest {
        enqueueSuccessMockResponse("competition.json")

        val result = footballRepository.getCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get competition is called with an error json body`() = runTest {
        "error.json".enqueueErrorMockResponse()

        val result = footballRepository.getCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get competition is called with an invalid body`() = runTest {
        "This is a malformed body".enqueueMalformedJsonErrorMockResponse()

        val result = footballRepository.getCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("HTTP 400 Client Error")
    }

    @Test
    fun `when get all matches in competition is called with a success response`() = runTest {
        enqueueSuccessMockResponse("matches_in_competition.json")

        val result = footballRepository.getAllMatchesInCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get all matches in competition is called with an error json body`() = runTest {
        "error.json".enqueueErrorMockResponse()

        val result = footballRepository.getAllMatchesInCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get all matches in competition is called with an invalid body`() = runTest {
        "This is a malformed body".enqueueMalformedJsonErrorMockResponse()

        val result = footballRepository.getAllMatchesInCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message)
            .contains("HTTP 400 Client Error")
    }

    private fun enqueueSuccessMockResponse(fileName: String) {
        val source = JsonParser.jsonStringFromFile(fileName)
        val mockResponse = MockResponse()
        mockResponse.setBody(source)
        mockResponse.setResponseCode(200)
        server.enqueue(mockResponse)
    }

    private fun String.enqueueErrorMockResponse() {
        val source = JsonParser.jsonStringFromFile(this)
        val mockResponse = MockResponse()
        mockResponse.setBody(source)
        mockResponse.setResponseCode(403)
        server.enqueue(mockResponse)
    }

    private fun String.enqueueMalformedJsonErrorMockResponse() {
        val mockResponse = MockResponse()
        mockResponse.setBody(this)
        mockResponse.setResponseCode(400)
        server.enqueue(mockResponse)
    }
}