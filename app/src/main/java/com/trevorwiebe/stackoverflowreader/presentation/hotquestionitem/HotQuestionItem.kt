package com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HotQuestionItem(
    questionId: String?,
    siteId: String?,
    viewModel: HotQuestionItemViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = questionId.toString())
        Text(text = siteId.toString())
    }
}