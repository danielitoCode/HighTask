package com.elitec.hightask

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource

import hightask.composeapp.generated.resources.Res
import hightask.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        val imageUrls = listOf(
            "https://picsum.photos/id/1015/600/400",
            "https://picsum.photos/id/1016/600/400",
            "https://picsum.photos/id/1020/600/400",
            "https://picsum.photos/id/1024/600/400",
            "https://picsum.photos/id/1027/600/400",
            "https://picsum.photos/id/1035/600/400",
            "https://picsum.photos/id/1039/600/400",
            "https://picsum.photos/id/1040/600/400",
            "https://picsum.photos/id/1041/600/400",
            "https://picsum.photos/id/1042/600/400",
            "https://picsum.photos/id/1043/600/400",
            "https://picsum.photos/id/1050/600/400"
        )
        val heroImageUrl =
            "https://avatars.githubusercontent.com/u/129673020?v=4"
        var showContent by remember { mutableStateOf(false) }
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(imageUrls) { url ->
                AsyncImage(
                    model = url,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}