package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.stackoverflowreader.RetrofitInstance
import com.trevorwiebe.stackoverflowreader.data.tts.TTSHelper
import com.trevorwiebe.stackoverflowreader.presentation.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HotQuestionsViewModel @Inject constructor(
    val ttsHelper: TTSHelper
): ViewModel() {

    private val _state = MutableStateFlow(HotQuestionsState())
    val state: StateFlow<HotQuestionsState> = _state.asStateFlow()

    init {
        loadHotQuestions()
        Handler(Looper.getMainLooper()).postDelayed({
            // This method will be executed once the timer is over
                val text = "Hello, this is a sample text to be spoken."
                ttsHelper.speak(text)
            //                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            }, 3000 // value in milliseconds
        )
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