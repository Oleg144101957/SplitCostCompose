package com.vishnevskiypro.splitcostcompose

import com.vishnevskiypro.splitcostcompose.database.DatabaseRepository

lateinit var REPOSITORY : DatabaseRepository

object Constants {

    object Screens {
        const val TRIP_SCREEN = "trip screen"
        const val ADD_TRIP_SCREEN = "cost screen"
        const val ONE_TRIP_SCREEN = "one cost screen"
        const val UPDATE_TRIP_SCREEN = "one cost screen"
        const val COST_SCREEN = "cost screen"
        const val ADD_COST_SCREEN = "cost screen"
        const val ONE_COST_SCREEN = "one cost screen"
    }

    object Database{
        const val ROOM_DATABASE_NAME = "split_cost_db"
        const val TRIP_TABLE = "trip_table"
    }

    object Keys{
        const val ID = "id"
        const val IDTOUPDATE = "idToUpdate"
        const val NONE = "none"
    }


}