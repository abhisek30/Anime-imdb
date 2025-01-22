package com.anime.imdb.app.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.imdb.app.domain.repository.IAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: IAnimeRepository
) : ViewModel() {

    init {
        getAnimeList()
    }

    private fun getAnimeList() {
        viewModelScope.launch {
            val result = repository.getAnimeList()
            Log.e("TAG", "${result}", )
        }
    }
}