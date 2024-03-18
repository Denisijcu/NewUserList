package com.denisijcu.newuserlist.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.denisijcu.newuserlist.viewmodel.MainViewModel
import kotlinx.coroutines.time.delay

// View
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        isLoading = viewModel.users.isEmpty()
    }

    LoadingScreen(isLoading = isLoading)


    LazyColumn {
        itemsIndexed(viewModel.users) { _, user ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = {
                    // Handle item click
                    isLoading = true

                }

            ) {


                if (isLoading) {
                    LaunchedEffect(true) {
                        viewModel.fetchData()
                        isLoading = viewModel.users.isEmpty()
                    }
                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {

                    Text("Records: ? ${viewModel.users.size}")
                    UserCard(user = user)
                }
            }
        }
    }
}

@Composable
fun LoadingScreen(isLoading: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
        }
    }
}



