package com.vishnevskiypro.splitcostcompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vishnevskiypro.splitcostcompose.Constants


@Entity(tableName = Constants.Database.TRIP_TABLE)
data class Trip (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val tripName: String = "some name",
    @ColumnInfo
    val tripAvatar: String = "default_trip_avatar"
)