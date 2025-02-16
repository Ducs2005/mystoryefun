package com.example.storyefun.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommentSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Bình luận (56)", fontSize = 18.sp)
        CommentItem(username = "Hayao Miyazaki", date = "11/10/2024", comment = "Truyện rất hay!")
        CommentItem(username = "Hayao Miyazaki", date = "11/10/2024", comment = "Truyện rất hay!")
        CommentItem(username = "Hayao Miyazaki", date = "11/10/2024", comment = "Truyện rất hay!")
        CommentItem(username = "Hayao Miyazaki", date = "11/10/2024", comment = "Truyện rất hay! rất hay! rất hay!rất hay! rất hay! rất hay! rất hay!  ")
        CommentItem(username = "Hayao Miyazaki", date = "11/10/2024", comment = "Truyện rất hay!")
        CommentItem(username = "Hayao Miyazaki", date = "11/10/2024", comment = "Truyện rất hay!")

    }
}
