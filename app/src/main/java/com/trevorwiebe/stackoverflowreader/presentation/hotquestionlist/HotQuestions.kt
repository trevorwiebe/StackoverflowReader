package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

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
            HotQuestionItem(
                points = it.display_score.toInt().toString(),
                questionTitle = it.title,
                category = it.site,
                tagsList = it.tags,
                onClick = {
                    viewModel.onEvent(HotQuestionsEvents.OnQuestionSelected(it))
                }
            )
        }
    }

}