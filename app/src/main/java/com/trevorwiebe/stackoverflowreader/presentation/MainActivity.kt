package com.trevorwiebe.stackoverflowreader.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem.HotQuestionItemScreen
import com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist.HotQuestions
import com.trevorwiebe.stackoverflowreader.presentation.ui.theme.StackOverflowReaderTheme
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackOverflowReaderTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                titleContentColor = MaterialTheme.colorScheme.onBackground,
                            ),
                            title = {
                                Text("Stackoverflow Reader")
                            },
                            actions = {
                                IconButton(onClick = {  }) {
                                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                                }
                            }
                        )
                    }
                ) {
                    HotQuestionsApp(it)
                }
            }
        }
    }

    @Composable
    fun HotQuestionsApp(innerPadding: PaddingValues) {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = HotQuestionsListDestination.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = HotQuestionsListDestination.route){
                HotQuestions(
                    onItemClick = { questionId, siteId ->
                        navController.navigate(HotQuestionItemDestination.route + "/$questionId/$siteId")
                    }
                )
            }
            composable(
                route = HotQuestionItemDestination.route +
                        "/{${HotQuestionItemDestination.questionId}}" +
                        "/{${HotQuestionItemDestination.siteId}}",
                arguments = listOf(
                    navArgument(HotQuestionItemDestination.questionId) {
                        type = NavType.StringType
                    }
                )
            ){
                HotQuestionItemScreen()
            }
        }

    }
}