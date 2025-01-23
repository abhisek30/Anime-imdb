package com.anime.imdb.app.presentation.animeList

import com.anime.imdb.app.domain.models.AnimeList

sealed class AnimeListEffect {
    data class NavigateToAnimeDetails(val id: Int): AnimeListEffect()
}

sealed class AnimeListIntent {

    data class AnimeCta(val id: Int) : AnimeListIntent()
}

data class AnimeListState(
    val animeList: AnimeList? = null,
)