package com.example.storyefun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.storyefun.ui.screens.*



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavHost(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("register") { RegisterScreen(navController) }


        composable("bookDetail") { BookDetailScreen() }
        composable("read") { ReaderScreen() }

        composable("Home") { HomeScreen(navController) }
        composable("AccountBox") { BookDetailScreen() }
        composable("AddCircle") { HomeScreen(navController) }
        composable("FavoriteBorder") { FavoriteScreen() }
        composable("Settings") { ReaderScreen() }
    }
}

