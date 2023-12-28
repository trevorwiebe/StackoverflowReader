package com.trevorwiebe.stackoverflowreader.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.trevorwiebe.stackoverflowreader.presentation.hotquestionitem.HotQuestionItemScreen
import com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist.HotQuestions
import com.trevorwiebe.stackoverflowreader.presentation.settings.SettingsScreen
import com.trevorwiebe.stackoverflowreader.presentation.ui.components.BaseScaffold
import com.trevorwiebe.stackoverflowreader.presentation.ui.components.SettingsScaffold
import com.trevorwiebe.stackoverflowreader.presentation.ui.theme.StackOverflowReaderTheme
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackOverflowReaderTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = HotQuestionsListDestination.route
                ){

                    setListAndDetail(navController)
                    setSettings(navController)
                }
            }
        }
    }
}

fun NavGraphBuilder.setListAndDetail(navController: NavController){
    composable(route = HotQuestionsListDestination.route){
        BaseScaffold(
            title = "Stackoverflow Reader",
            navController = navController
        ) {paddingValues ->
            HotQuestions(
                onItemClick = { questionId, siteId ->
                    navController.navigate(HotQuestionItemDestination.route + "/$questionId/$siteId")
                },
                paddingValues = paddingValues
            )
        }
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
        BaseScaffold(
            title = "Answer",
            navController = navController
        ) {
            HotQuestionItemScreen(paddingValues = it)
        }
    }
}

fun NavGraphBuilder.setSettings(navController: NavController){
    composable(route = HotQuestionsSettings.route){
        SettingsScaffold {
            SettingsScreen(paddingValues = it)
        }
    }
}