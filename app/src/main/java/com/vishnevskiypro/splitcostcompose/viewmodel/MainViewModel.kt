package com.vishnevskiypro.splitcostcompose.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vishnevskiypro.splitcostcompose.REPOSITORY
import com.vishnevskiypro.splitcostcompose.database.AppRoomDatabase
import com.vishnevskiypro.splitcostcompose.database.repository.RoomRepository
import com.vishnevskiypro.splitcostcompose.model.Trip
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application){

    val context = application

    fun initDatabase(){
        val dao = AppRoomDatabase.getInstance(context).getRoomDao()
        REPOSITORY = RoomRepository(dao)
    }

    fun addTripToViewModel(trip: Trip, onSuccess : () -> Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.createTrip(trip){
                viewModelScope.launch (Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    fun updateTripInViewModel(trip: Trip, onSuccess: () -> Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.updateTrip(trip){
                viewModelScope.launch (Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    fun readAllTrips() = REPOSITORY.readAllTrips

}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }

        throw IllegalArgumentException("Unknown View")
    }
}