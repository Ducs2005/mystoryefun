package com.example.storyefun.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.storyefun.ui.screens.*
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object BookDetail : Screen("bookDetail")
    object Login : Screen("login")
    object Register : Screen("register")
    object Reader : Screen("reader")


}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.BookDetail.route) {BookDetailScreen(navController)}
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.Reader.route) { ReaderScreen(navController) }


    }
}
