package com.example.storyefun.ui

import UploadScreen
import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.profileui.ProfileScreen
import com.example.storyefun.ui.screens.*
import com.example.storyefun.ui.theme.ThemeViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object BookDetail : Screen("bookDetail")
    object Login : Screen("login")
    object Upload : Screen("upload")
    object Reader : Screen("reader")
    object Register : Screen("register")
    object Profile : Screen("profile")
    object MyStory : Screen("mystory")
    object Setting : Screen("setting")
    object Category : Screen("AccountBox")

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(navController: NavHostController, themeViewModel: ThemeViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.BookDetail.route) {BookDetailScreen(navController)}
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.Reader.route) { ReaderScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Upload.route) { UploadScreen(navController) }
        composable(Screen.MyStory.route) { MyStoryScreen(navController) }
        composable(Screen.Setting.route) { SettingScreen(navController, themeViewModel) }
        composable(Screen.Category.route) { CategoryScreen(navController) }


    }
}
