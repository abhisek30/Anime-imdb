package com.anime.imdb.app.presentation.animeDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anime.imdb.app.presentation.animeDetails.components.AnimeDetailsView

@Composable
fun AnimeDetailsContent(modifier: Modifier = Modifier, id: Int) {

    val viewmodel = hiltViewModel<AnimeDetailsViewModel>()
    val uiState = viewmodel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewmodel.handleIntent(AnimeDetailsIntent.Init(id))
    }


    uiState.value.animeDetails?.let { details ->
        LazyColumn (
            modifier = modifier.fillMaxSize().padding(horizontal = 12.dp),
        ) {
            item {
                AnimeDetailsView(
                    modifier = Modifier.padding(top = 12.dp),
                    posterImage = details.trailer.images.maximumImageUrl,
                    title = details.title,
                    noOfEpisode = details.episodes.toString(),
                    rating = details.score.toString(),
                    plot = details.synopsis,
                    genres = details.genres.map { it.name },
                    videoId = details.trailer.youtubeId,
                )
            }
        }
    } ?: run {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
private fun AnimeDetailsContentPreview() {
    AnimeDetailsContent(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        id = 1,
    )
}