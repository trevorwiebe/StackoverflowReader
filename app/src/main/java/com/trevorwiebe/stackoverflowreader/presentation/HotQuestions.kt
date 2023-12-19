package com.trevorwiebe.stackoverflowreader.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HotQuestions(
    viewModel: HotQuestionsViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    LazyColumn{
        items(state.hotQuestions){
            HotQuestionItem(questionTitle = it.title)
        }
    }

}