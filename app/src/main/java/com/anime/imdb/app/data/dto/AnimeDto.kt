package com.anime.imdb.app.data.dto

import com.google.gson.annotations.SerializedName

data class AnimeListDto(
    @SerializedName("pagination") val pagination: PaginationDto? = null,
    @SerializedName("data") val data: ArrayList<DataDto>? = arrayListOf(),
)

data class AnimeDetailDto(
    @SerializedName("data") val data: DataDto? = null,
)

data class PaginationDto(
    @SerializedName("last_visible_page") val lastVisiblePage: Int? = null,
    @SerializedName("has_next_page") val hasNextPage: Boolean? = null,
    @SerializedName("current_page") val currentPage: Int? = null,
    @SerializedName("items") val items: ItemsDto? = null,
)

data class ItemsDto(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("per_page") val perPage: Int? = null,
)


data class ImagesDto(
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("small_image_url") val smallImageUrl: String? = null,
    @SerializedName("medium_image_url") val mediumImageUrl: String? = null,
    @SerializedName("large_image_url") val largeImageUrl: String? = null,
    @SerializedName("maximum_image_url") val maximumImageUrl: String? = null
)

data class TrailerDto(
    @SerializedName("youtube_id") val youtubeId: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("embed_url") val embedUrl: String? = null,
    @SerializedName("images") val images: ImagesDto? = ImagesDto()
)

data class GenresDto(
    @SerializedName("mal_id") val malId: Int? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null
)

data class DataDto(
    @SerializedName("mal_id") val malId: Int? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("images") val images: ImagesDto? = ImagesDto(),
    @SerializedName("trailer") val trailer: TrailerDto? = TrailerDto(),
    @SerializedName("approved") val approved: Boolean? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("title_english") val titleEnglish: String? = null,
    @SerializedName("title_japanese") val titleJapanese: String? = null,
    @SerializedName("title_synonyms") val titleSynonyms: ArrayList<String> = arrayListOf(),
    @SerializedName("type") val type: String? = null,
    @SerializedName("source") val source: String? = null,
    @SerializedName("episodes") val episodes: Int? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("airing") val airing: Boolean? = null,
    @SerializedName("duration") val duration: String? = null,
    @SerializedName("rating") val rating: String? = null,
    @SerializedName("score") val score: Double? = null,
    @SerializedName("scored_by") val scoredBy: Int? = null,
    @SerializedName("rank") val rank: Int? = null,
    @SerializedName("popularity") val popularity: Int? = null,
    @SerializedName("members") val members: Int? = null,
    @SerializedName("favorites") val favorites: Int? = null,
    @SerializedName("synopsis") val synopsis: String? = null,
    @SerializedName("background") val background: String? = null,
    @SerializedName("season") val season: String? = null,
    @SerializedName("year") val year: Int? = null,
    @SerializedName("genres") val genres: ArrayList<GenresDto> = arrayListOf(),
    @SerializedName("explicit_genres") val explicitGenres: ArrayList<String> = arrayListOf(),
    @SerializedName("themes") val themes: ArrayList<Any> = arrayListOf(),
)