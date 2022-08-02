package com.vishnevskiypro.splitcostcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vishnevskiypro.splitcostcompose.model.Trip
import com.vishnevskiypro.splitcostcompose.navigation.NavRoute
import com.vishnevskiypro.splitcostcompose.viewmodel.MainViewModel

@Composable
fun AddTripScreen(navController: NavController, viewModel: MainViewModel) {

    var tripName by remember { mutableStateOf("") }
    var tripAvatar by remember { mutableStateOf("") }
    var isButtonAddEnabled = false

    Scaffold() {
        Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            Text(
                text = "Add Your Trip",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = tripName,
                onValueChange = {
                    tripName = it
                    isButtonAddEnabled = tripName.isNotEmpty() && tripAvatar.isNotEmpty()
                },
                label = { Text(text = "Enter Trip Name") },
                isError = tripName.isEmpty()
            )

            OutlinedTextField(
                value = tripAvatar,
                onValueChange = {
                    tripAvatar = it
                    isButtonAddEnabled = tripName.isNotEmpty() && tripAvatar.isNotEmpty()
                },
                label = { Text(text = "Enter Avatar Trip") },
                isError = tripAvatar.isEmpty()
            )

            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isButtonAddEnabled,
                onClick = {
                    viewModel.addTripToViewModel(
                        trip = Trip(tripName = tripName, tripAvatar = tripAvatar)){
                        navController.navigate(NavRoute.TripScreen.route)
                    }
                }) {
                Text(text = "Add Trip To Database")
            }
        }
    }
}