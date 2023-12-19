package com.trevorwiebe.stackoverflowreader.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trevorwiebe.stackoverflowreader.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

@HiltViewModel
class HotQuestionsViewModel(

): ViewModel() {

    init {
        loadHotQuestions()
    }

    private fun loadHotQuestions(){
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.api.getHotQuestions()
            } catch(e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response", e)
                return@launch
            }
            if(response.isSuccessful && response.body() != null) {
                Log.d(TAG, "onCreate: Successful")
                Log.d(TAG, "onCreate: ${response.body()}")
            } else {
                Log.e(TAG, "Response not successful")
            }
        }
    }
}