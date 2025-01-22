package com.anime.imdb.app.domain.models

data class AnimeList(
    val pagination: Pagination,
    val data: ArrayList<Data>,
)

data class Pagination(
    val lastVisiblePage: Int,
    val hasNextPage: Boolean,
    val currentPage: Int,
    val items: Items,
)

data class Items(
    val count: Int,
    val total: Int,
    val perPage: Int,
)


data class Images(
    val imageUrl: String,
    val smallImageUrl: String,
    val mediumImageUrl: String,
    val largeImageUrl: String,
    val maximumImageUrl: String
)

data class Trailer(
    val youtubeId: String,
    val url: String,
    val embedUrl: String,
    val images: Images
)

data class Genres(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
)

data class Data(
    val malId: Int,
    val url: String,
    val images: Images,
    val trailer: Trailer,
    val approved: Boolean,
    val title: String,
    val titleEnglish: String,
    val titleJapanese: String,
    val titleSynonyms: ArrayList<String>,
    val type: String,
    val source: String,
    val episodes: Int,
    val status: String,
    val airing: Boolean,
    val duration: String,
    val rating: String,
    val score: Double,
    val scoredBy: Int,
    val rank: Int,
    val popularity: Int,
    val members: Int,
    val favorites: Int,
    val synopsis: String,
    val background: String,
    val season: String,
    val year: Int,
    val genres: ArrayList<Genres>,
    val explicitGenres: ArrayList<String>,
    val themes: ArrayList<Any>,
)