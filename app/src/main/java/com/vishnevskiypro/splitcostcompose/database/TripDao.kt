package com.vishnevskiypro.splitcostcompose.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vishnevskiypro.splitcostcompose.model.Trip


@Dao
interface TripDao {

    @Query("SELECT * FROM trip_table")
    fun getAllTrips() : LiveData<List<Trip>>

    @Insert
    suspend fun addTripToDatabase(trip: Trip)

    @Delete
    suspend fun deleteTripFromDatabase(trip: Trip)

    @Update
    suspend fun updateTripInDatabase(trip: Trip)


}