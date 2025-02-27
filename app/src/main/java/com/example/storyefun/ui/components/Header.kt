package com.example.storyefun.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.storyefun.R
import com.example.storyefun.navigation.nav



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    text: String,
    active: Boolean,
    onQueryChange: (String) -> Unit,
    onActiveChange: (Boolean) -> Unit,
    navController: NavController
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
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold ,
                    //modifier = Modifier.clickable({navController.navigate("home")})
                )
                Text(
                    text = "STORYEFUN",
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start=8.dp)
                )
            }
            // Right
            Row(modifier = Modifier.padding(5.dp)) {
                IconButton(onClick = {navController.navigate("profile")}) { Icon(Icons.Default.Person, contentDescription = "person") }
                IconButton(onClick = {navController.navigate("setting")}) { Icon(Icons.Default.Settings, contentDescription = "settingss") }
            }
        }

        Divider(modifier = Modifier.padding(horizontal = 20.dp))

        /* unnessesary part
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
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "Welcome back to Storyefun",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }

         */

        // SearchBar
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
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
