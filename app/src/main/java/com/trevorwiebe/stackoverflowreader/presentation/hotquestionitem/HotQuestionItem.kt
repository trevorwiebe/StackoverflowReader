package com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HotQuestionItem(
    questionId: String?
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = questionId.toString())
    }
}