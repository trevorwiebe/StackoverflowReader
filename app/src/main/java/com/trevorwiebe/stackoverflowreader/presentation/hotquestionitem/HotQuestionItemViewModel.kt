package com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.stackoverflowreader.data.tts.TTSHelper
import com.trevorwiebe.stackoverflowreader.data.util.FILTER
import com.trevorwiebe.stackoverflowreader.domain.usecases.GetQuestion
import com.trevorwiebe.stackoverflowreader.presentation.HotQuestionItemDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotQuestionItemViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val ttsHelper: TTSHelper,
    val getQuestion: GetQuestion
): ViewModel() {

    private val questionId: String = checkNotNull(
        savedStateHandle[HotQuestionItemDestination.questionId]
    )
    private val siteId: String = checkNotNull(
        savedStateHandle[HotQuestionItemDestination.siteId]
    )

    private val _state = MutableStateFlow(QuestionState())
    val state: StateFlow<QuestionState> = _state.asStateFlow()

    init {
        loadQuestion(questionId, siteId, FILTER)
    }

    fun onEvent(events: QuestionEvents){
        when(events){
            is QuestionEvents.OnNarrationPaused -> {
                ttsHelper.shutdown()
            }
        }
    }

    private fun loadQuestion(
        questionId: String,
        siteId: String,
        filter: String
    ){
        viewModelScope.launch {
            val response = getQuestion(
                questionId = questionId,
                siteId = siteId,
                filter = filter
            )
            if(response != null){
                _state.update { it.copy(itemList = response.items.toList()) }

                var speakString = ""
                response.items.forEachIndexed { index, item ->
                    val stringResponse = item.bodyMarkdown
                    if(index != 0) {
                        speakString = speakString.plus("Next answer: ")
                    }
                    speakString = speakString.plus(stringResponse)
                }

                ttsHelper.speak(speakString)
            }
        }
    }

}