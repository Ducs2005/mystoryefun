package com.example.storyefun.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storyefun.ui.theme.LocalAppColors
import com.example.storyefun.ui.theme.ThemeViewModel
@Composable
fun SettingScreen(navController: NavController? = null, themeViewModel: ThemeViewModel) {
    val colors = LocalAppColors.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.backgroundColor) // Set background from theme
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Prevents content from touching edges
        ) {
            // 🔹 Custom Header (Replaces TopAppBar)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back button
                navController?.let {
                    IconButton(onClick = { it.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = colors.textPrimary
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Title with Theme Background
                Text(
                    text = "Cài đặt",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.textPrimary,
                    modifier = Modifier
                        .background(colors.backgroundColor) // Apply theme background
                        .padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🔹 Settings Options
            val settingsItems = listOf(
                "Tài khoản và Bảo mật",
                "Dọn dẹp các tệp tạm thời",
                "Chặn đoán mạng",
                "Quản lý thông báo",
                "Độ phân giải của ảnh",
                "Thiết lập tự động mua"
            )

            Column {
                settingsItems.forEach { title ->
                    SettingsItem(title = title, textColor = colors.textPrimary, onClick = { /* Handle click */ })
                }

                // 🔹 Dark Mode Toggle
                DarkModeToggle(themeViewModel, colors.textPrimary)

                // 🔹 Language Setting
                SettingsItem(
                    title = "Đa ngôn ngữ",
                    subtitle = "Tiếng Việt",
                    textColor = colors.textPrimary,
                    onClick = { /* Handle language change */ }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // 🔹 Logout Button (Styled Same as Settings Items)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /* Handle logout */ }
                    .background(colors.backgroundColor) // Apply same background as items
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Thoát đăng nhập",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colors.textPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


// 🔹 Settings Item
@Composable
fun SettingsItem(title: String, subtitle: String? = null, textColor: Color, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = textColor)
            subtitle?.let {
                Text(text = it, fontSize = 14.sp, color = Color.Gray)
            }
        }
        Icon(Icons.Default.ArrowForward, contentDescription = "Next", tint = Color.Gray)
    }
}

// 🔹 Dark Mode Toggle
@Composable
fun DarkModeToggle(themeViewModel: ThemeViewModel, textColor: Color) {
    val isDarkMode by themeViewModel.isDarkTheme.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Chế độ ban đêm", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = textColor)
        Switch(checked = isDarkMode, onCheckedChange = { themeViewModel.toggleTheme() })
    }
}
