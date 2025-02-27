package com.example.profileui

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.storyefun.R
import com.example.storyefun.ui.screens.HomeScreen



@Composable
fun ProfileScreen(navController: NavController) {

    var darkMode by remember { mutableStateOf(false) }
    val backgroundColor = if (darkMode) Color.Black else Color.White // Chế độ tối = đen
    val textColor = if (darkMode) Color.White else Color.Black // Chữ trắng khi dark mode
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (darkMode) Color.Black else Color.White)
            .padding(16.dp)
    ) {
        // Avatar + Name + Location
        ProfileHeader(textColor)

        Spacer(modifier = Modifier.height(16.dp))

        // Settings Section
        SettingsSection(navController,darkMode, textColor, { darkMode = it }) { destination ->
            // Xử lý điều hướng dựa vào destination
            when (destination) {
                "home" -> navController.navigate("login") // Điều hướng tới Home
                "favourite" -> navController.navigate("login") // Điều hướng tới trang yêu thích
                "account" -> navController.navigate("login") // Điều hướng tới tài khoản
                "contact" -> navController.navigate("login") // Điều hướng tới liên hệ
                "out" -> println("Đăng xuất") // Xử lý đăng xuất
            }
        }
    }
}

@Composable
fun ProfileHeader(textColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Chiếm toàn bộ chiều rộng
            .padding(vertical = 32.dp), // Tạo khoảng cách phía trên và dưới
        contentAlignment = Alignment.Center // Căn giữa nội dung trong Box
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ava),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Hoàng Văn Sỹ", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = textColor)
            Spacer(modifier = Modifier.height(15.dp))
            ProfileStats(textColor)
        }
    }
}

@Composable
fun ProfileStats(textColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem("122", "followers", textColor)
        StatItem("67", "following" , textColor)
        StatItem("37K", "likes", textColor)
    }
}
@Composable
fun StatItem(number: String, label: String,textColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = number, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E2E5D))
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
    }
}
@Composable
fun SettingsSection(
    navController: NavController,
    darkMode: Boolean,
                    textColor: Color,
                    onDarkModeToggle: (Boolean) -> Unit,
                    onItemClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Settings",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = textColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        SettingItem("Chế độ tối", Icons.Default.Face, switch = true, darkMode, textColor, onDarkModeToggle)
        SettingItem("tai khoan", Icons.Default.Person, darkMode = darkMode, textColor = textColor, onClick = {
            navController.navigate("login")
        })

        SettingItem("truyen yêu thích", Icons.Default.Favorite, darkMode = darkMode, textColor = textColor){onItemClick("login")}
        SettingItem("them truyen", Icons.Default.Add, darkMode = darkMode, textColor = textColor){onItemClick("login")}
        SettingItem("Lien he", Icons.Default.Call, darkMode = darkMode, textColor = textColor){onItemClick("login")}
        SettingItem("Dang xuat" , Icons.Default.ExitToApp, darkMode = darkMode, textColor = textColor){onItemClick("login")}
    }
}

@Composable
fun SettingItem(
    title: String,
    icon: ImageVector,
    switch: Boolean = false,
    darkMode: Boolean = false,
    textColor: Color,
    onDarkModeToggle: ((Boolean) -> Unit)? = null,
    onClick: (() -> Unit)? = null // ✅ Thêm sự kiện click
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(
                onClick = { onClick?.invoke() },
                indication = LocalIndication.current, // ✅ Ripple mới của Material 3
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(12.dp), // Tăng padding cho dễ bấm
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = textColor,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 20.sp,
            color = textColor
        )
        Spacer(modifier = Modifier.weight(1f))
        if (switch) {
            Switch(
                checked = darkMode,
                onCheckedChange = { onDarkModeToggle?.invoke(it) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = if (darkMode) Color.White else Color.Black,
                    checkedTrackColor = if (darkMode) Color.Gray else Color.LightGray
                )
            )
        }
    }
}



