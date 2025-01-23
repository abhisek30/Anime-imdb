package com.anime.imdb.app.presentation.animeDetails

import com.anime.imdb.app.domain.models.Data

sealed class AnimeDetailsIntent {
    data class Init(val id: Int) : AnimeDetailsIntent()
}

data class AnimeDetailsState(
    val animeDetails: Data? = null,
)