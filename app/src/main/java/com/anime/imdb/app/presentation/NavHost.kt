package com.anime.imdb.app.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.anime.imdb.app.presentation.animeList.AnimeListContent
import kotlinx.serialization.Serializable

@Composable
fun NavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = AnimeScreen.AnimeListScreen,
        modifier = modifier
    ) {

        composable<AnimeScreen.AnimeListScreen> {
            AnimeListContent(navigateToDetails = {
                navController.navigate(AnimeScreen.AnimeDetailsScreen(it))
            })
        }

        composable<AnimeScreen.AnimeDetailsScreen> { backstackEntry ->
            val id = backstackEntry.toRoute<AnimeScreen.AnimeDetailsScreen>()
        }

    }
}


@Serializable
sealed class AnimeScreen {

    @Serializable
    data object AnimeListScreen : AnimeScreen()

    @Serializable
    data class AnimeDetailsScreen(val id: Int) : AnimeScreen()
}