package com.devtamuno.domain.di

import com.devtamuno.domain.mapper.CompetitionMapper
import com.devtamuno.domain.mapper.response.AllCompetitionMapper
import com.devtamuno.domain.mapper.response.AllTeamsInCompetitionMapper
import com.devtamuno.domain.mapper.response.CompetitionMatchesMapper
import com.devtamuno.domain.repository.FootballRepository
import com.devtamuno.domain.repository.FootballRepositoryImpl
import com.devtamuno.football.remote.repository.FootballRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @[Provides Singleton]
    internal fun providesFootballRepository(
        remoteRepository: FootballRemoteRepository,
        allCompetitionMapper: AllCompetitionMapper,
        allTeamsInCompetitionMapper: AllTeamsInCompetitionMapper,
        competitionMapper: CompetitionMapper,
        competitionMatchesMapper: CompetitionMatchesMapper,
    ): FootballRepository {

        return FootballRepositoryImpl(
            remoteRepository,
            allCompetitionMapper,
            allTeamsInCompetitionMapper,
            competitionMapper,
            competitionMatchesMapper
        )
    }
}