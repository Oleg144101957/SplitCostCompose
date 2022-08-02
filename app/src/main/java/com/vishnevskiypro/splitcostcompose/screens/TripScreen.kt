package com.vishnevskiypro.splitcostcompose.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vishnevskiypro.splitcostcompose.model.Trip
import com.vishnevskiypro.splitcostcompose.navigation.NavRoute
import com.vishnevskiypro.splitcostcompose.viewmodel.MainViewModel


@Composable
fun TripScreen(navController: NavController, viewModel: MainViewModel) {

    val trips = viewModel.readAllTrips().observeAsState(listOf()).value

    Scaffold(
        floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate(NavRoute.AddTripScreen.route)
        }) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Trip",
                tint = Color.White
            )
        }
    }) {
        LazyColumn{
            items(trips){ trip ->
                TripItem(trip = trip, navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TripItem(trip: Trip, navController: NavController){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp, horizontal = 24.dp)
        .combinedClickable(
            onClick = {
                navController.navigate(NavRoute.OneTripScreen.route + "/${trip.id}")
            },
            onLongClick = {
                //Update
            },
        ),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = trip.tripName)
            Text(text = trip.tripAvatar)
        }
    }
}

