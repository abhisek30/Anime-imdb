package com.anime.imdb.app.presentation.animeList

import com.anime.imdb.app.domain.models.Data

sealed class AnimeListEffect {
    data class NavigateToAnimeDetails(val id: Int): AnimeListEffect()
}

sealed class AnimeListIntent {

    data class AnimeCta(val id: Int) : AnimeListIntent()

    data object LoadMore: AnimeListIntent()
}

data class AnimeListState(
    val animeList: MutableList<Data>? = null,
    val isPaginationLoading: Boolean = false,
    val currentPage: Int = 0,
    val hasNextPage: Boolean = true,
)