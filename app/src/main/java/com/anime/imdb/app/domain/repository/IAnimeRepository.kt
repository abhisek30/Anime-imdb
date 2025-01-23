package com.anime.imdb.app.domain.repository

import com.anime.imdb.app.domain.models.AnimeList
import com.anime.imdb.app.domain.models.Data

interface IAnimeRepository {
    suspend fun getAnimeList(page: Int?) : Result<AnimeList>

    suspend fun getAnimeById(id: Int) : Result<Data>
}