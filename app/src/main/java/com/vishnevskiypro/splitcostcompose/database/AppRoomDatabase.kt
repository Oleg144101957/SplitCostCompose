package com.vishnevskiypro.splitcostcompose.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vishnevskiypro.splitcostcompose.Constants.Database.ROOM_DATABASE_NAME
import com.vishnevskiypro.splitcostcompose.model.Trip

@Database(entities = [Trip::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase(){

    abstract fun getRoomDao() : TripDao

    companion object{

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context) : AppRoomDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    ROOM_DATABASE_NAME
                ).build()
                INSTANCE as AppRoomDatabase
            } else INSTANCE as AppRoomDatabase
        }
    }
}