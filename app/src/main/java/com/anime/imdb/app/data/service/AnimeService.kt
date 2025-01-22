package com.anime.imdb.app.data.service

import com.anime.imdb.app.data.dto.AnimeListDto
import retrofit2.Response
import retrofit2.http.GET

interface AnimeService {

    @GET("/v4/top/anime")
    suspend fun getAnimeList() : Response<AnimeListDto>
}