package com.vishnevskiypro.splitcostcompose.database

import androidx.lifecycle.LiveData
import com.vishnevskiypro.splitcostcompose.model.Trip

interface DatabaseRepository {

    val readAllTrips: LiveData<List<Trip>>

    suspend fun createTrip(trip: Trip, onSuccess : () -> Unit)

    suspend fun updateTrip(trip: Trip, onSuccess : () -> Unit)

    suspend fun deleteTrip(trip: Trip, onSuccess : () -> Unit)


}