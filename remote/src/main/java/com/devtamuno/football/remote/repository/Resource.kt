package com.devtamuno.football.remote.repository

import com.devtamuno.football.remote.data.ErrorDataRemote
import java.io.IOException
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import retrofit2.Response


@OptIn(ExperimentalSerializationApi::class)
private val config = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
}

sealed class Resource<out R> {
    data class Success<out R>(val result: R) : Resource<R>()
    data class Failure(val message: String) : Resource<Nothing>()
}

suspend fun <R> resourceHelper(body: suspend () -> R): Resource<R> {
    return try {
        Resource.Success(body())
    } catch (e: HttpException) {
        val errorDataRemote = getErrorMessage(e.response())
        if (errorDataRemote == null) Resource.Failure("Check your network connection")
        else Resource.Failure(errorDataRemote.message)
    } catch (io: IOException) {
        Resource.Failure("Check your network connection")
    } catch (e: Throwable) {
        Resource.Failure(e.message ?: "Unknown error")
    }
}

private fun getErrorMessage(response: Response<*>?): ErrorDataRemote? {
    return try {
        val errorBody = response?.errorBody()?.byteStream()?.readBytes()?.let { String(it) }
            ?: return null
        return config.decodeFromString<ErrorDataRemote>(errorBody)
    } catch (e: Exception) {
        null
    }
}
