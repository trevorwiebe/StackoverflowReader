package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

sealed class HotQuestionsEvents{
    data class OnQuestionSelected(val questionsTitle: String): HotQuestionsEvents()
}
