package com.medicare.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.medicare.myapplication.ui.theme.MyApplicationTheme
import android.content.Intent
import android.net.Uri
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
        private val serviceIntent by lazy {Intent(this, BackgroundAudioService::class.java)}
        private val musicViewModel: MusicViewModel by viewModels()
        private val gameStatsViewModel: GameStatsViewModel by viewModels()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (musicViewModel.isMusicPlaying.value) {
            startMusicService()
        }

        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()
                ) {
                    MyRNGenApp(musicViewModel, gameStatsViewModel)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMusicService()
    }

    override fun onStop() {
        super.onStop()
        stopMusicService()
    }

    private fun startMusicService() {
        val serviceIntent = Intent(this, BackgroundAudioService::class.java)
        startService(serviceIntent)
    }

    private fun stopMusicService() {
        val serviceIntent = Intent(this, BackgroundAudioService::class.java)
        stopService(serviceIntent)
    }
}
@Composable
fun MyRNGenApp(musicViewModel: MusicViewModel = viewModel(),gameStatsViewModel: GameStatsViewModel = viewModel()){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash",
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeIn(animationSpec = tween(durationMillis = 200))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeOut(animationSpec = tween(durationMillis = 200))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeIn(animationSpec = tween(durationMillis = 200))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeOut(animationSpec = tween(durationMillis = 200))
        }
    ){
        composable("splash") { SplashScreen(navController) }
        composable("home") { Home(navController, musicViewModel,gameStatsViewModel) }
        composable("classic") { ClassicGameScreen(musicViewModel,gameStatsViewModel) }
        composable("expert") { ExpertGameScreen(musicViewModel,gameStatsViewModel) }
        composable("custom") { CustomGameCreateScreen(musicViewModel,gameStatsViewModel,navController) }
        composable("history") { History(musicViewModel,gameStatsViewModel) }
        composable(
            route = "customgame/{lowerLim}/{upperLim}/{maxtrials}",
            arguments = listOf(
                navArgument("lowerLim") { type = NavType.StringType },
                navArgument("upperLim") { type = NavType.StringType },
                navArgument("maxtrials") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val lowerLim = backStackEntry.arguments?.getString("lowerLim")?.toIntOrNull() ?: 0
            val upperLim = backStackEntry.arguments?.getString("upperLim")?.toIntOrNull() ?: 0
            val maxtrails = backStackEntry.arguments?.getString("maxtrials")?.toIntOrNull() ?: 0
            CustomGamePlayScreen(musicViewModel,gameStatsViewModel,lowerLim, upperLim, maxtrails)
        }
    }
}



