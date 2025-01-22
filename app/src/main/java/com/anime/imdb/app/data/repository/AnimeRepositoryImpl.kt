package com.anime.imdb.app.data.repository

import com.anime.imdb.app.data.mapper.AnimeMapper.toModel
import com.anime.imdb.app.data.service.AnimeService
import com.anime.imdb.app.domain.models.AnimeList
import com.anime.imdb.app.domain.repository.IAnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val apiService : AnimeService
) : IAnimeRepository {

    override suspend fun getAnimeList(): Result<AnimeList> {
        return try {
            val result = apiService.getAnimeList()
            if(result.isSuccessful) {
                result.body()?.toModel()?.let {
                    Result.success(it)
                } ?: run {
                    Result.failure(Exception(result.message()))
                }
            } else {
                Result.failure(Exception(result.message()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}