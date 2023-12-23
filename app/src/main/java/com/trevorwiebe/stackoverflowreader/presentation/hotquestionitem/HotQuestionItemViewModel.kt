package com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.stackoverflowreader.data.tts.TTSHelper
import com.trevorwiebe.stackoverflowreader.data.util.FILTER
import com.trevorwiebe.stackoverflowreader.domain.usecases.GetQuestion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotQuestionItemViewModel @Inject constructor(
    val ttsHelper: TTSHelper,
    val getQuestion: GetQuestion
): ViewModel() {

    init {
        loadQuestion("205140", "academia", FILTER)
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
            Log.d("TAG", "loadQuestion: $response")
        }
    }

}