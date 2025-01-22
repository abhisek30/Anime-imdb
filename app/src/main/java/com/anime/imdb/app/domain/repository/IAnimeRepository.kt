package com.anime.imdb.app.domain.repository

import com.anime.imdb.app.domain.models.AnimeList

interface IAnimeRepository {
    suspend fun getAnimeList() : Result<AnimeList>
}