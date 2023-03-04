package com.devtamuno.football.remote.utils

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.net.HttpURLConnection
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
class MockOkHttpServer<T>(
    private val service: Class<T>,
) {

    private val server: MockWebServer = MockWebServer()

    private val kotlinSerializationConverterFactory =
        JsonParser.jsonConfig.asConverterFactory("application/json".toMediaType())

    private val retrofit = Retrofit.Builder()
        .baseUrl(server.url("")) //leave url empty, otherwise it'll attempt to make a network call
        .addConverterFactory(kotlinSerializationConverterFactory)
        .build()


    fun shotDownServer() = server.shutdown()

    fun getRequestPath() = server.takeRequest().path

    fun getPreparedService(): T = retrofit.create(service)

    fun enqueueJsonMockResponse(fileName: String, responseCode: Int = HttpURLConnection.HTTP_OK) {
        val source = JsonParser.jsonStringFromFile(fileName)
        val mockResponse = MockResponse()
        mockResponse.setBody(source)
        mockResponse.setResponseCode(responseCode)
        server.enqueue(mockResponse)
    }

    fun enqueueTextMockResponse(text: String, responseCode: Int) {
        val mockResponse = MockResponse()
        mockResponse.setBody(text)
        mockResponse.setResponseCode(responseCode)
        server.enqueue(mockResponse)
    }


}