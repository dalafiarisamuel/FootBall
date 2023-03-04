package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.api.FootballService
import com.devtamuno.football.remote.utils.MockOkHttpServer
import com.google.common.truth.Truth.assertThat
import java.net.HttpURLConnection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FootballRemoteRepositoryImplTest {

    private lateinit var service: FootballService
    private lateinit var footballRepository: FootballRemoteRepositoryImpl
    private lateinit var server: MockOkHttpServer<FootballService>

    @Before
    fun setUp() {
        server = MockOkHttpServer(FootballService::class.java)
        service = server.getPreparedService()
        footballRepository = FootballRemoteRepositoryImpl(service)
    }

    @After
    fun tearDown() {
        server.shotDownServer()
    }

    @Test
    fun `when get all competition is called with a success response`() = runTest {
        server.enqueueJsonMockResponse("competitions.json")

        val result = footballRepository.getAllCompetitions()

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get all competition is called with an error json body`() = runTest {
        server.enqueueJsonMockResponse("error.json", HttpURLConnection.HTTP_UNAUTHORIZED)

        val result = footballRepository.getAllCompetitions()

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get all competition is called with an invalid body`() = runTest {
        server.enqueueTextMockResponse(
            "This is a malformed body", HttpURLConnection.HTTP_BAD_REQUEST
        )

        val result = footballRepository.getAllCompetitions()

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("HTTP 400 Client Error")
    }

    @Test
    fun `when get teams in competition is called with a success response`() = runTest {
        server.enqueueJsonMockResponse("teams_in_competition.json")

        val result = footballRepository.getTeamsInCompetition(2016)

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get teams in competition is called with an error json body`() = runTest {
        server.enqueueJsonMockResponse("error.json", HttpURLConnection.HTTP_UNAUTHORIZED)

        val result = footballRepository.getTeamsInCompetition(2016)

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get teams in competition is called with an invalid body`() = runTest {
        server.enqueueTextMockResponse(
            "This is a malformed body", HttpURLConnection.HTTP_BAD_REQUEST
        )

        val result = footballRepository.getTeamsInCompetition(2016)

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("HTTP 400 Client Error")
    }

    @Test
    fun `when get competition is called with a success response`() = runTest {
        server.enqueueJsonMockResponse("competition.json")

        val result = footballRepository.getCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get competition is called with an error json body`() = runTest {
        server.enqueueJsonMockResponse("error.json", HttpURLConnection.HTTP_UNAUTHORIZED)

        val result = footballRepository.getCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get competition is called with an invalid body`() = runTest {
        server.enqueueTextMockResponse(
            "This is a malformed body",
            HttpURLConnection.HTTP_BAD_REQUEST
        )
        val result = footballRepository.getCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("HTTP 400 Client Error")
    }

    @Test
    fun `when get all matches in competition is called with a success response`() = runTest {
        server.enqueueJsonMockResponse("matches_in_competition.json")

        val result = footballRepository.getAllMatchesInCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Success::class.java)
        assertThat((result as Resource.Success).result).isNotNull()
    }

    @Test
    fun `when get all matches in competition is called with an error json body`() = runTest {
        server.enqueueJsonMockResponse("error.json", HttpURLConnection.HTTP_UNAUTHORIZED)

        val result = footballRepository.getAllMatchesInCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("The resource you are looking for is restricted")
    }

    @Test
    fun `when get all matches in competition is called with an invalid body`() = runTest {
        server.enqueueTextMockResponse(
            "This is a malformed body",
            HttpURLConnection.HTTP_BAD_REQUEST
        )

        val result = footballRepository.getAllMatchesInCompetition("PL")

        assertThat(result).isInstanceOf(Resource.Failure::class.java)
        assertThat((result as Resource.Failure).message).contains("HTTP 400 Client Error")
    }
}