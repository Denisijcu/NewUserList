package com.denisijcu.newuserlist.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.denisijcu.newuserlist.model.User


@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Left side - Image
            UrlImage(url = user.avatar)
        }

        // Middle - Name and LastName
        Row(
            modifier = Modifier
                .padding(start = 16.dp)

        ) {

            Text(text = user.firstName+ " "+ user.lastName,
                Modifier.padding(6.dp), style = TextStyle(fontSize = 28.sp, color = Color.Black)
            )
            //  Text(text = student.lastName, style = TextStyle(fontSize = 28.sp, color = Color.DarkGray))
        }

    }
}

