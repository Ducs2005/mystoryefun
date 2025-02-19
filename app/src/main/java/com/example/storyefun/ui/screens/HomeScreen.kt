@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.storyefun.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.graphics.Color
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
import com.example.storyefun.R
import com.google.firebase.auth.FirebaseAuth

@ExperimentalMaterial3Api
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Storyefun",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6200EE),
                            fontSize = 26.sp)
                        )
                        },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar() {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Menu, contentDescription = "Home")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorites")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Home, contentDescription = "Home")
                }

                Spacer(modifier = Modifier.weight(0.1f))

                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.AddCircle,
                        contentDescription = "Add",
                        modifier = Modifier.size(100.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(0.1f))

                IconButton(onClick = {}) {
                    Icon(Icons.Default.Share, contentDescription = "Share")
                }

                IconButton(onClick = { }) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Notifications, contentDescription = "Home")
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Banner()
            }
            item {
                Navigation2()
            }
            item {
                ContinueRead()
            }
            item {
                Stories()
            }
        }
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
fun Navigation2(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(){
            IconButton(
                onClick = {},
                modifier = Modifier
                    .width(80.dp)

            ) {
                Icon(painter = painterResource(id=R.drawable.book1) , contentDescription = null, tint = Color(0xFFFF520E))
            }
            Text(
                text = "Truyện tranh",
            )
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Column(){
            IconButton(
                onClick = {},
                modifier = Modifier
                    .width(80.dp)
            ) {
                Icon(painter = painterResource(id=R.drawable.book2), contentDescription = "null", tint = Color(0xEEE80B3F))
            }
            Text(
                text = "Truyện chữ",
            )
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Column(){
            IconButton(
                onClick = {},
                modifier = Modifier
                    .width(80.dp)
            ) {
                Icon(painter = painterResource(id=R.drawable.like), contentDescription = "null", tint = Color(0xFF199DCE))

            }
            Text(
                text = "Sách yêu thích",
            )
        }
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
@Preview
@Composable
fun PreviewHome(){
    HomeScreen()
}
