package com.denisijcu.newuserlist.view

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun UrlImage(url: String, modifier: Modifier = Modifier) {
    val painter = // Enable crossfade animation
        rememberAsyncImagePainter(
            ImageRequest.Builder // Placeholder while loading
            // Placeholder on failure
                (LocalContext.current).data(data = url).apply(block = fun ImageRequest.Builder.() {
                crossfade(true) // Enable crossfade animation
                placeholder(R.drawable.ic_menu_gallery) // Placeholder while loading
                error(R.drawable.ic_menu_close_clear_cancel) // Placeholder on failure
            }).build()
        )

    Image(
        painter = painter,
        contentDescription = null, // Content description can be null for decorative images
        modifier = Modifier
            .size(840.dp, 300.dp)
            .padding(0.dp)
            .fillMaxWidth(),
    )
}


