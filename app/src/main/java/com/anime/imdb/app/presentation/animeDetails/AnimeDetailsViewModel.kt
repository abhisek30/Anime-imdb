package com.anime.imdb.app.presentation.animeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.imdb.app.domain.repository.IAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    private val repository: IAnimeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AnimeDetailsState())
    val uiState: StateFlow<AnimeDetailsState> = _uiState

    fun handleIntent(intent: AnimeDetailsIntent) {
        viewModelScope.launch {
            when(intent) {
                is AnimeDetailsIntent.Init -> {
                    getAnimeList(intent.id)
                }
            }
        }
    }

    private fun getAnimeList(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getAnimeById(id)
            result.onSuccess { animeDetails ->
                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(
                        animeDetails = animeDetails
                    )
                }
            }
        }
    }
}