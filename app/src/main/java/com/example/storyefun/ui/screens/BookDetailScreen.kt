package com.example.storyefun.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.storyefun.R
import com.example.storyefun.ui.components.*

@Composable
fun BookDetailScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedTabIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background3), // Replace with your background image
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .matchParentSize()



        )

        // Foreground Content
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SearchBar(searchQuery, onQueryChange = { searchQuery = it })

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                MangaInfo()
                Column(modifier = Modifier.fillMaxSize()) {
                    // Tabs
                    TabRow(
                        selectedTabIndex = selectedTabIndex,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Tab(
                            selected = selectedTabIndex == 0,
                            onClick = { selectedTabIndex = 0 },
                            text = { Text("Thông tin") }
                        )
                        Tab(
                            selected = selectedTabIndex == 1,
                            onClick = { selectedTabIndex = 1 },
                            text = { Text("Chapter") }
                        )
                    }

                    // Content based on selected tab
                    when (selectedTabIndex) {
                        0 -> InformationSection()
                        1 -> ChapterListSection()
                    }
                }
            }
        }
    }
}


@Composable
fun MangaInfo() {
    Row {
        Image(
            painter = rememberImagePainter("https://s.fanfox.net/store/manga/15291/03-024.0/compressed/d020.jpg"),
            contentDescription = "Manga Cover",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Image(
                painter = rememberImagePainter("https://s.fanfox.net/store/manga/15291/03-024.0/compressed/d020.jpg"),
                contentDescription = "Preview",
                modifier = Modifier.size(100.dp)
            )

        }
    }
    Text(text = "Spirited Away", fontSize = 24.sp, color = Color.Black)
    Text(text = "Hayao Miyazaki", fontSize = 16.sp, color = Color.Gray)

    // Stats Row
    Row(modifier = Modifier.padding(top = 8.dp)) {
        Text("👁️ 23.4K  |  📅 2004  |  ❤️ 300.7K", fontSize = 14.sp, color = Color.Gray)
    }

    Divider(
        color = Color.Gray,  // Line color
        thickness = 1.dp,    // Line thickness
        modifier = Modifier.padding(vertical = 8.dp)
    )


}

@Composable
fun ReadButton() {
    Button(
        onClick = { /* Start Reading */ },
        colors = ButtonDefaults.buttonColors(Color.Red),
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
    ) {
        Text("Bắt đầu đọc", fontSize = 18.sp, color = Color.White)
    }
}


@Composable
fun MangaDescription() {
    val genres = listOf("Action", "Horror", "Romance", "Manga", "Adventure", "Fantasy", "Drama", "Comedy")

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 90.dp), // Auto-fit based on width
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(genres.size) { index ->
            GenreTag(genres[index])
        }
    }

    Text(
        text = "Mô tả: Spirited Away follows Chihiro, a young girl trapped in a mystical world...",
        fontSize = 14.sp,
        modifier = Modifier.padding(top = 8.dp)
    )
}


@Composable
fun GenreTag(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(4.dp)
            .background(Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp),
        color = Color.White
    )
}

@Composable
fun InformationSection()
{
    MangaDescription()
    ReadButton()
    CommentSection()
}

@Composable
fun ChapterListSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Chapter (90)",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp) // Space below the title
        )
        Text(
            text = "Cập nhật mới nhất 29/02/2024",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 12.dp) // Space below the update info
        )

        // Sample chapters
        for (i in 1..3) {
            Text(
                text = "Tập $i: ABC xyz",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp) // Spacing between volume titles
            )
            for (j in 1..3) {
                Text(
                    text = "Chương $j: Mở đầu 2 tên chương dài...  11/10/2024",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp, bottom = 6.dp) // Indent and space chapters
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MangaDetailScreenPreview() {
    BookDetailScreen()
}
