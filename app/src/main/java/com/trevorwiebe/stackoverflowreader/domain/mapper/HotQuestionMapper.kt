package com.trevorwiebe.stackoverflowreader.domain.mapper

import com.trevorwiebe.stackoverflowreader.data.dto.HotQuestionDto
import com.trevorwiebe.stackoverflowreader.domain.HotQuestion

fun HotQuestionDto.toHotQuestion(): HotQuestion {
    return HotQuestion(
        site = site,
        questionId = question_id,
        title = title,
        displayScore = display_score,
        iconUrl = icon_url,
        creationDate = creation_date,
        answerCount = answer_count,
        userName = user_name,
        tags = tags
    )
}