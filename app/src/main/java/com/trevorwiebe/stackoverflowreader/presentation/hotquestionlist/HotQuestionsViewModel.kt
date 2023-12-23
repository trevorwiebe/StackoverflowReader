package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.stackoverflowreader.data.tts.TTSHelper
import com.trevorwiebe.stackoverflowreader.domain.usecases.GetHotQuestions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotQuestionsViewModel @Inject constructor(
    val ttsHelper: TTSHelper,
    val getHotQuestions: GetHotQuestions
): ViewModel() {

    private val _state = MutableStateFlow(HotQuestionsState())
    val state: StateFlow<HotQuestionsState> = _state.asStateFlow()

    init {
        loadHotQuestions()
    }

    private fun loadHotQuestions() {
        viewModelScope.launch {
            val response = getHotQuestions()
            if(response!= null){
                _state.update { it.copy(hotQuestions = response) }
            }
        }
    }
}