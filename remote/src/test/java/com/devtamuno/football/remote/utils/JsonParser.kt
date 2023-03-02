package com.devtamuno.football.remote.utils

import java.io.Reader
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okio.buffer
import okio.source

@OptIn(ExperimentalSerializationApi::class)
object JsonParser {

    val jsonConfig = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    inline fun <reified T : Any> parseJson(fileName: String): T {
        val jsonString = jsonStringFromFile(fileName)
        return jsonConfig.decodeFromString(jsonString)
    }

    fun jsonStringFromFile(fileName: String): String {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        return inputStream.bufferedReader().use(Reader::readText)
    }

    fun jsonStringFromFile2(fileName: String): String {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName).source().buffer()
        return inputStream.readString(Charsets.UTF_8)
    }
}