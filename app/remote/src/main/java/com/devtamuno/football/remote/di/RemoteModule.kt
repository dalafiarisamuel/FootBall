package com.devtamuno.football.remote.di


import com.devtamuno.football.remote.api.FootballService
import com.devtamuno.football.remote.api.FootballServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.timeout
import io.ktor.client.request.header
import io.ktor.client.request.host
import io.ktor.http.URLProtocol
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json


@Module
@InstallIn(SingletonComponent::class)
@OptIn(ExperimentalSerializationApi::class)
internal object RemoteModule {

    @[Provides Singleton]
    fun providesHttpClient(): HttpClient {
        return HttpClient(Android) {
            defaultRequest {
                header("X-Auth-Token", "")
                timeout {
                    requestTimeoutMillis = TimeUnit.SECONDS.toMillis(30)
                    connectTimeoutMillis = TimeUnit.SECONDS.toMillis(30)
                    socketTimeoutMillis = TimeUnit.SECONDS.toMillis(30)
                }
                host = "api.football-data.org/v4/"
                url {
                    protocol = URLProtocol.HTTPS
                }
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
        }
    }

    @[Provides Singleton]
    fun providesFootballService(client: HttpClient): FootballService {
        return FootballServiceImpl(client)
    }

}