package com.vishnevskiypro.splitcostcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vishnevskiypro.splitcostcompose.model.Trip
import com.vishnevskiypro.splitcostcompose.navigation.NavRoute
import com.vishnevskiypro.splitcostcompose.viewmodel.MainViewModel

@Composable
fun OneTripScreen(navController: NavController, viewModel: MainViewModel, tripId: String?){

    val trips = viewModel.readAllTrips().observeAsState(listOf()).value
    val oneTrip = trips.firstOrNull { it.id == tripId?.toInt() } ?: Trip(
        tripName = "Unknown Trip",
        tripAvatar = "unknown Avatar"
    )

    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .padding(32.dp)) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = oneTrip.tripName)
                    Text(text = oneTrip.tripAvatar)
                }
            }
        }
    }
}