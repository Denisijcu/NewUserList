package com.denisijcu.newuserlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.denisijcu.newuserlist.ui.theme.NewUserListTheme
import com.denisijcu.newuserlist.view.MainScreen
import com.denisijcu.newuserlist.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

             val viewModel = MainViewModel()

            LaunchedEffect(true) {
               viewModel.fetchData()
            }

            NewUserListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MainScreen(viewModel)
                }
            }
        }
    }
}



@Composable
fun MainScreenPreview(viewModel: MainViewModel) {
    NewUserListTheme {
      MainScreen(viewModel)
    }
}