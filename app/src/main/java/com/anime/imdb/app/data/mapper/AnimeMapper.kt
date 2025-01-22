package com.anime.imdb.app.data.mapper

import com.anime.imdb.app.data.dto.*
import com.anime.imdb.app.domain.models.*

object AnimeMapper {

    fun AnimeListDto.toModel() = AnimeList(
        pagination = pagination?.toModel() ?: Pagination(0, false, 0, Items(0, 0, 0)),
        data = data?.map { it.toModel() }?.toCollection(ArrayList()) ?: arrayListOf()
    )

    fun PaginationDto.toModel() = Pagination(
        lastVisiblePage = lastVisiblePage ?: 0,
        hasNextPage = hasNextPage ?: false,
        currentPage = currentPage ?: 0,
        items = items?.toModel() ?: Items(0, 0, 0)
    )

    fun ItemsDto.toModel() = Items(
        count = count ?: 0,
        total = total ?: 0,
        perPage = perPage ?: 0
    )

    fun ImagesDto.toModel() = Images(
        imageUrl = imageUrl ?: "",
        smallImageUrl = smallImageUrl ?: "",
        mediumImageUrl = mediumImageUrl ?: "",
        largeImageUrl = largeImageUrl ?: "",
        maximumImageUrl = maximumImageUrl ?: ""
    )

    fun TrailerDto.toModel() = Trailer(
        youtubeId = youtubeId ?: "",
        url = url ?: "",
        embedUrl = embedUrl ?: "",
        images = images?.toModel() ?: Images("", "", "", "", "")
    )

    fun GenresDto.toModel() = Genres(
        malId = malId ?: 0,
        type = type ?: "",
        name = name ?: "",
        url = url ?: ""
    )

    fun DataDto.toModel() = Data(
        malId = malId ?: 0,
        url = url ?: "",
        images = images?.toModel() ?: Images("", "", "", "", ""),
        trailer = trailer?.toModel() ?: Trailer("", "", "", Images("", "", "", "", "")),
        approved = approved ?: false,
        title = title ?: "",
        titleEnglish = titleEnglish ?: "",
        titleJapanese = titleJapanese ?: "",
        titleSynonyms = ArrayList(titleSynonyms),
        type = type ?: "",
        source = source ?: "",
        episodes = episodes ?: 0,
        status = status ?: "",
        airing = airing ?: false,
        duration = duration ?: "",
        rating = rating ?: "",
        score = score ?: 0.0,
        scoredBy = scoredBy ?: 0,
        rank = rank ?: 0,
        popularity = popularity ?: 0,
        members = members ?: 0,
        favorites = favorites ?: 0,
        synopsis = synopsis ?: "",
        background = background ?: "",
        season = season ?: "",
        year = year ?: 0,
        genres = genres.map { it.toModel() }.toCollection(ArrayList()),
        explicitGenres = ArrayList(explicitGenres),
        themes = ArrayList(themes)
    )
}