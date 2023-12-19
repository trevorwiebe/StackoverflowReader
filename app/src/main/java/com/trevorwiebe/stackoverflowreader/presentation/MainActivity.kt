package com.trevorwiebe.stackoverflowreader.presentation

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.trevorwiebe.stackoverflowreader.presentation.ui.theme.StackOverflowReaderTheme
import java.util.Locale

const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackOverflowReaderTheme {
                HotQuestions()
            }
        }

    }

    private val textToSpeechEngine: TextToSpeech by lazy {
        // Pass in context and the listener.
        TextToSpeech(this) { status ->
            // set our locale only if init was success.
            if (status == TextToSpeech.SUCCESS) {
                Toast.makeText(this, "TTS setup success", Toast.LENGTH_LONG).show()
                textToSpeechEngine.language = Locale.US
            }else{
                Toast.makeText(this, "TTS setup success", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun startTTS(textInput: String){
        val text = textInput.trim()
        if (text.isNotEmpty()) {
            textToSpeechEngine.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts1")
        } else {
            Toast.makeText(this, "Text cannot be empty", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        textToSpeechEngine.stop()
        textToSpeechEngine.shutdown()
        super.onDestroy()
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StackOverflowReaderTheme {
        Greeting("Android")
    }
}