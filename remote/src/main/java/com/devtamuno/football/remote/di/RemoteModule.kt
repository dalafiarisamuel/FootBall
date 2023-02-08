package com.devtamuno.football.remote.di


import com.devtamuno.football.remote.api.FootballService
import com.devtamuno.football.remote.repository.FootballRemoteRepository
import com.devtamuno.football.remote.repository.FootballRemoteRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit


@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
internal object RemoteModule {

    @[Provides Singleton]
    fun providesRetrofit(): Retrofit {

        val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)

        okHttpBuilder.addInterceptor { chain: Interceptor.Chain ->
            val request = chain.request()
            val newRequest =
                request.newBuilder().header("X-Auth-Token", "")
            chain.proceed(newRequest.build())
        }

        val config = Json {
            ignoreUnknownKeys = true
            explicitNulls = false
        }

        return Retrofit.Builder().baseUrl("https://api.football-data.org/v4/")
            .addConverterFactory(config.asConverterFactory("application/json".toMediaType()))
            .client(okHttpBuilder.build()).build()
    }

    @[Provides Singleton]
    fun providesFootballService(client: Retrofit): FootballService {
        return client.create(FootballService::class.java)
    }

    @[Provides Singleton]
    fun providesFootballRemoteRepository(service: FootballService): FootballRemoteRepository {
        return FootballRemoteRepositoryImpl(service)
    }

}