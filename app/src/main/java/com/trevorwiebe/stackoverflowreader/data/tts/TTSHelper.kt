package com.trevorwiebe.stackoverflowreader.data.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class TTSHelper(private val tts: TextToSpeech) {

    fun speak(text: String) {
        tts.setLanguage(Locale.getDefault())
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun shutdown() {
        tts.stop()
        tts.shutdown()
    }
}