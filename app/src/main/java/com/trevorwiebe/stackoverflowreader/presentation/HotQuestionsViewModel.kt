package com.trevorwiebe.stackoverflowreader.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.stackoverflowreader.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HotQuestionsViewModel(

): ViewModel() {

    private val _state = MutableStateFlow(HotQuestionsState())
    val state: StateFlow<HotQuestionsState> = _state.asStateFlow()

    init {
        loadHotQuestions()
    }

    private fun loadHotQuestions() {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.api.getHotQuestions()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response", e)
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {

                _state.update { it.copy(hotQuestions = response.body()!!) }

            } else {

            }
        }
    }
}