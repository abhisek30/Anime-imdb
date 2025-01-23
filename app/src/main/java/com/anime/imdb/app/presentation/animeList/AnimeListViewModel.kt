package com.anime.imdb.app.presentation.animeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.imdb.app.domain.models.Data
import com.anime.imdb.app.domain.repository.IAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel @Inject constructor(
    private val repository: IAnimeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AnimeListState())
    val uiState: StateFlow<AnimeListState> = _uiState

    private val _uiEffect = MutableSharedFlow<AnimeListEffect>()
    val uiEffect : SharedFlow<AnimeListEffect> = _uiEffect

    private val animeListItems: MutableList<Data> = mutableListOf()

    init {
        getAnimeList()
    }

    fun handleIntent(intent: AnimeListIntent) {
        viewModelScope.launch {
            when(intent) {
                is AnimeListIntent.AnimeCta -> {
                    _uiEffect.emit(AnimeListEffect.NavigateToAnimeDetails(intent.id))
                }

                is AnimeListIntent.LoadMore -> {
                    if(!_uiState.value.isPaginationLoading && _uiState.value.hasNextPage) {
                        getAnimeList()
                    }
                }
            }
        }
    }

    private fun getAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            if(_uiState.value.currentPage > 1) {
                _uiState.value = _uiState.value.copy(
                    isPaginationLoading = true,
                )
            }
            val result = repository.getAnimeList(_uiState.value.currentPage.inc())
            result.onSuccess { animeList ->
                withContext(Dispatchers.Main) {
                    animeListItems.addAll(animeList.data)
                    _uiState.value = _uiState.value.copy(
                        animeList = animeListItems,
                        isPaginationLoading = false,
                        currentPage = animeList.pagination.currentPage,
                        hasNextPage = animeList.pagination.hasNextPage,
                    )
                }
            }
        }
    }
}