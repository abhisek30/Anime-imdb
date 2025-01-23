package com.anime.imdb.app.presentation.animeDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun AnimeDetailsView(
    modifier: Modifier = Modifier,
    posterImage: String,
    title: String,
    noOfEpisode: String,
    rating: String,
    plot: String,
    genres: List<String>,
    videoId: String,
) {
    Column(modifier = modifier) {
        if(videoId.isNotBlank()) {
            VideoPlayer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                videoId = videoId

            )
        } else {
            SubcomposeAsyncImage(
                model = posterImage,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                error = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Error Loading Image")
                    }
                },
                loading = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                }
            )
        }

        Text(
            text = title,
            modifier = Modifier.padding(top = 12.dp, start = 12.dp),
            fontWeight = FontWeight.Bold
        )

        Row(modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)) {
            Text(
                text = "Number of Episodes : ${noOfEpisode}",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Rating : ${rating}/10",
            )
        }

        Text(
            text = "Genre(s) : ${genres.joinToString(", ")}",
            modifier = Modifier.padding(top = 12.dp, start = 12.dp),
        )

        Text(
            text = "Plot : ${plot}",
            modifier = Modifier.padding(top = 12.dp, start = 12.dp),
        )


    }
}

@Preview
@Composable
private fun AnimeDetailsViewPreview() {
    AnimeDetailsView(
        modifier = Modifier.fillMaxSize(),
        posterImage = "",
        title = "",
        noOfEpisode = "",
        rating = "",
        genres = emptyList(),
        plot = "",
        videoId = ""
    )
}