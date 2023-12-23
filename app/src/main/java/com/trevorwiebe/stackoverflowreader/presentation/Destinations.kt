package com.trevorwiebe.stackoverflowreader.presentation

interface Destinations {
    val route: String
}

object HotQuestionsListDestination: Destinations{
    override val route: String = "questions_list"
}

object HotQuestionItemDestination: Destinations{
    override val route: String = "question_item"
    const val questionId: String = "question_id"
    const val siteId: String = "site_id"
}