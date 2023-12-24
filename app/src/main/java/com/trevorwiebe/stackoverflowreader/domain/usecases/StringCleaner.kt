package com.trevorwiebe.stackoverflowreader.domain.usecases

import org.jsoup.Jsoup

class StringCleaner {

    operator fun invoke(raw: String?): String{

        return Jsoup.parse(raw).text()
    }
}