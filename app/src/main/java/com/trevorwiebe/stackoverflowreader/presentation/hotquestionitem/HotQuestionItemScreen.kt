package com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HotQuestionItemScreen(
    paddingValues: PaddingValues,
    viewModel: HotQuestionItemViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    val answerList = state.itemList

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues)
    ){
        items(answerList){item ->
            Answer(body = item.bodyMarkdown.toString())
        }
    }
}

@Composable
fun Answer(
    body: String
) {
    Row(
        modifier = Modifier
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = body,
            modifier = Modifier.padding(8.dp)
        )
    }
}