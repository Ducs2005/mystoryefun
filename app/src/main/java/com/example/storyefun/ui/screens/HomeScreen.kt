@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.storyefun.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.storyefun.R
import com.google.firebase.auth.FirebaseAuth

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { Header(text, active, onQueryChange = { text = it }, onActiveChange = { active = it }) },
        bottomBar = { }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            // Background image
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = "background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .graphicsLayer(alpha = 0.7f)
            )

            // Main content
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { Banner() }
                item { ContinueRead() }
                item { Stories() }
            }
        }
    }
}

@Composable
fun Header(
    text: String,
    active: Boolean,
    onQueryChange: (String) -> Unit,
    onActiveChange: (Boolean) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Header 1
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "ストリエフン",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "STORYEFUN",
                    color = Color.DarkGray
                )
            }
            // Right
            Row(modifier = Modifier.padding(5.dp)) {
                IconButton(onClick = {}) { Icon(Icons.Default.Person, contentDescription = "person") }
                IconButton(onClick = {}) { Icon(Icons.Default.Notifications, contentDescription = "notifications") }
                IconButton(onClick = {}) { Icon(Icons.Default.MoreVert, contentDescription = "morevert") }
            }
        }

        Divider(modifier = Modifier.padding(horizontal = 20.dp))

        // Header 2
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(50.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.padding(top = 15.dp)) {
                Text(
                    text = "Hi, Thanh Phuong!",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "Welcome back to Storyefun",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
        }

        // SearchBar
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            query = text,
            onQueryChange = onQueryChange,
            onSearch = { onActiveChange(false) },
            active = active,
            onActiveChange = onActiveChange,
            placeholder = { Text(text = "Search here...") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon") },
            shape = RoundedCornerShape(4.dp),
            colors = SearchBarDefaults.colors(containerColor = Color.White),
            trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (text.isNotEmpty()) {
                                onQueryChange("")
                            } else {
                                onActiveChange(false)
                            }
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close icon"
                    )
                }
            }
        ) {}
    }
}


@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bannerhome),
            contentDescription = "Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.White.copy(alpha = 0.2f))
        )
        Image(
            painter = painterResource(id = R.drawable.poster1),
            contentDescription = "Overlay Image",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 16.dp)
                .height(250.dp)
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun ContinueRead() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Continue Reading",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp),
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {},
                modifier = Modifier
                    .width(80.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Xem tất cả",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                    )
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.bannerhome),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
//                    .offset(y = 16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.poster1),
                contentDescription = "Overlay Image",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxWidth(0.5f)
                    .height(250.dp)
            )
        }
    }
}

@Composable
fun Stories() {
    val backgroundImages = listOf(
        R.drawable.banner2,
        R.drawable.banner3,
        R.drawable.banner4,
        R.drawable.bannerhome,
        R.drawable.bannerhome
    )

    val overlayImages = listOf(
        R.drawable.poster2,
        R.drawable.poster3,
        R.drawable.poster6,
        R.drawable.poster5,
        R.drawable.poster4
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Truyện ngắn",
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {},
                modifier = Modifier
                    .width(80.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Xem tất cả"
                    )
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(backgroundImages) { index, backgroundImage ->
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                ) {
                    Image(
                        painter = painterResource(id = backgroundImage),
                        contentDescription = "Banner",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Image(
                        painter = painterResource(id = overlayImages[index]),
                        contentDescription = "Overlay",
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .fillMaxWidth(0.5f)
                            .height(250.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    HomeScreen()
}
