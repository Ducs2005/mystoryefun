package com.example.storyefun.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val mangaList = listOf("One Piece", "Naruto", "Attack on Titan") // Sample Data

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Manga List", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(mangaList) { manga ->
                Text(
                    text = manga,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { /* Navigate to detail screen (later) */ }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("login") }) {
            //Text("Upload Manga")
        }
    }
}
