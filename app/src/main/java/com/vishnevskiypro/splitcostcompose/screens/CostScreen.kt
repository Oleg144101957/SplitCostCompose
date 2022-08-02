package com.vishnevskiypro.splitcostcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.vishnevskiypro.splitcostcompose.Constants
import com.vishnevskiypro.splitcostcompose.viewmodel.MainViewModel


@Composable
fun CostScreen(navController: NavController, viewModel: MainViewModel) {

    val context = LocalContext.current


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = Constants.Screens.COST_SCREEN)

        }

    }

}