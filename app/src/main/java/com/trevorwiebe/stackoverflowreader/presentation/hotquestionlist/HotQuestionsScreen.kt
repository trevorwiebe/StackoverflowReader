package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HotQuestions(
    viewModel: HotQuestionsViewModel = hiltViewModel(),
    onItemClick: (Int, String) -> Unit
) {

    val state by viewModel.state.collectAsState()

    LazyColumn{
        items(state.hotQuestions){question ->
            HotQuestionItem(
                points = question.displayScore.toInt().toString(),
                questionTitle = question.title,
                category = question.site,
                tagsList = question.tags,
                onClick = {
                    onItemClick(question.questionId, question.site)
                }
            )
        }
    }

}