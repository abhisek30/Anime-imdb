package com.anime.imdb.app.core.di

import com.anime.imdb.app.data.repository.AnimeRepositoryImpl
import com.anime.imdb.app.data.service.AnimeService
import com.anime.imdb.app.domain.repository.IAnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) : AnimeService {
        return retrofit.create(AnimeService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(animeRepositoryImpl: AnimeRepositoryImpl) : IAnimeRepository {
        return animeRepositoryImpl
    }

}