package com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem

import com.trevorwiebe.stackoverflowreader.data.dto.Items

data class QuestionState(
    val itemList: List<Items> = emptyList()
)
