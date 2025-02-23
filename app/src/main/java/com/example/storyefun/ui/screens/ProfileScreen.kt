package com.example.storyefun.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storyefun.R

@Composable
fun ProfileScreen(navController: NavController) {
    var avatar by remember { mutableStateOf(R.drawable.ava) }
    var username by remember { mutableStateOf("Hoàng Văn Sỹ") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 40.dp)
        ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { /* TODO: Mở bộ chọn ảnh */ },
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color.White, shape = CircleShape)
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = "Edit Avatar",
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = username,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 220.dp, start = 16.dp), // Thêm Modifier trước padding
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start // Sửa lỗi này
    ) {
        listOf(
            Pair(Icons.Default.CheckCircle, "Dark Mode"),
            Pair(Icons.Default.Person, "Edit Profile"),
            Pair(Icons.Default.Favorite, "Follow"),
            Pair(Icons.Default.Add, "Story"),
            Pair(Icons.Default.Call, "Contact us"),
            Pair(Icons.Default.Settings, "Sign Out")
        ).forEach { (icon, label) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding( vertical = 8.dp)
                    .clickable { navController.navigate("") }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = Color.Gray,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(
                    text = label,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}


