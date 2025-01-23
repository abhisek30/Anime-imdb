package com.anime.imdb.app.data.repository

import com.anime.imdb.app.data.mapper.AnimeMapper.toModel
import com.anime.imdb.app.data.service.AnimeService
import com.anime.imdb.app.domain.models.AnimeList
import com.anime.imdb.app.domain.models.Data
import com.anime.imdb.app.domain.repository.IAnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val apiService : AnimeService
) : IAnimeRepository {

    override suspend fun getAnimeList(page: Int?): Result<AnimeList> {
        return try {
            val result = apiService.getAnimeList(page)
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

    override suspend fun getAnimeById(id: Int): Result<Data> {
        return try {
            val result = apiService.getAnimeById(id)
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