package com.example.mvvm_demo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mvvm_demo.viewmodel.HomeViewModel

@Composable
fun HomePage(viewModel: HomeViewModel) {
    val userData = viewModel.userData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { viewModel.getUserData() }) {
            Text(text = "Get User Data")
        }
        if (isLoading.value == true) {
            Text(text = "Loading...")
        } else {
            userData.value?.name?.let {
                Text("Name: $it")
            }
            userData.value?.age?.let {
                Text("Age: $it")
            }
        }

    }
}