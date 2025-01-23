package com.anime.imdb.app.data.service

import com.anime.imdb.app.data.dto.AnimeDetailDto
import com.anime.imdb.app.data.dto.AnimeListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {

    @GET("/v4/top/anime")
    suspend fun getAnimeList(
        @Query("page") page: Int?
    ): Response<AnimeListDto>

    @GET("/v4/anime/{id}")
    suspend fun getAnimeById(@Path("id") id: Int): Response<AnimeDetailDto>
}