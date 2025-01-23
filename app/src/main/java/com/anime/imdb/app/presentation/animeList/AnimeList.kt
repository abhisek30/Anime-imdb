package com.anime.imdb.app.presentation.animeList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anime.imdb.app.presentation.animeList.components.AnimeListCard
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun AnimeListContent(modifier: Modifier = Modifier, navigateToDetails: (Int) -> Unit) {

    val viewmodel = hiltViewModel<AnimeListViewModel>()
    val uiState = viewmodel.uiState.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(key1 = listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }
            .collect { visibleItems ->
                if (visibleItems.isNotEmpty() && visibleItems.last().index >= listState.layoutInfo.totalItemsCount - 1 && uiState.value.hasNextPage) {
                    viewmodel.handleIntent(AnimeListIntent.LoadMore)
                }
            }
    }

    uiState.value.animeList?.let { animeList ->
        LazyColumn(
            modifier = modifier.padding(horizontal = 12.dp),
            state = listState
        ) {
            items(animeList) { anime ->
                AnimeListCard(
                    modifier = Modifier.padding(top = 12.dp),
                    posterImage = anime.trailer.images.maximumImageUrl,
                    title = anime.title,
                    noOfEpisode = anime.episodes.toString(),
                    rating = anime.score.toString(),
                    onClick = {
                        viewmodel.handleIntent(AnimeListIntent.AnimeCta(anime.malId))
                    }
                )
            }

            if (uiState.value.isPaginationLoading) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                }
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

    LaunchedEffect(Unit) {
        viewmodel.uiEffect.onEach { effect ->
            when (effect) {
                is AnimeListEffect.NavigateToAnimeDetails -> {
                    navigateToDetails(effect.id)
                }
            }
        }.collect()
    }
}

@Preview
@Composable
private fun AnimeListContentPreview() {
    AnimeListContent(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        navigateToDetails = {}
    )
}