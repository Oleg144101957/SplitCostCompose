package com.vishnevskiypro.splitcostcompose.database.repository

import androidx.lifecycle.LiveData
import com.vishnevskiypro.splitcostcompose.database.DatabaseRepository
import com.vishnevskiypro.splitcostcompose.database.TripDao
import com.vishnevskiypro.splitcostcompose.model.Trip

class RoomRepository (private val tripDao : TripDao): DatabaseRepository {

    override val readAllTrips: LiveData<List<Trip>>
        get() = tripDao.getAllTrips()

    override suspend fun createTrip(trip: Trip, onSuccess: () -> Unit) {
        tripDao.addTripToDatabase(trip)
        onSuccess()
    }

    override suspend fun updateTrip(trip: Trip, onSuccess: () -> Unit) {
        tripDao.updateTripInDatabase(trip)
        onSuccess()
    }

    override suspend fun deleteTrip(trip: Trip, onSuccess: () -> Unit) {
        tripDao.deleteTripFromDatabase(trip)
        onSuccess()
    }
}