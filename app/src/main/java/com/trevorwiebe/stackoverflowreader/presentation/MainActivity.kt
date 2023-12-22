package com.trevorwiebe.stackoverflowreader.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist.HotQuestions
import com.trevorwiebe.stackoverflowreader.presentation.ui.theme.StackOverflowReaderTheme
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackOverflowReaderTheme {
                HotQuestionsApp()
            }
        }
    }

    @Composable
    fun HotQuestionsApp() {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = HotQuestionsList.route
        ){
            composable(route = HotQuestionsList.route){
                HotQuestions()
            }
        }

    }
}