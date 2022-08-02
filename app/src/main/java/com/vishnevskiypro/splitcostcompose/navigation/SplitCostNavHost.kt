package com.vishnevskiypro.splitcostcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishnevskiypro.splitcostcompose.Constants
import com.vishnevskiypro.splitcostcompose.screens.*
import com.vishnevskiypro.splitcostcompose.viewmodel.MainViewModel


sealed class NavRoute(val route: String){

    object TripScreen: NavRoute(Constants.Screens.TRIP_SCREEN)
    object AddTripScreen: NavRoute(Constants.Screens.ADD_TRIP_SCREEN)
    object OneTripScreen: NavRoute(Constants.Screens.ONE_TRIP_SCREEN)

}

@Composable
fun SplitCostNavHost(viewModel : MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.TripScreen.route){

        composable(NavRoute.TripScreen.route){
            TripScreen(
                navController = navController,
                viewModel = viewModel)
        }

        composable(NavRoute.AddTripScreen.route){
            AddTripScreen(
                navController = navController,
                viewModel = viewModel)
        }

        composable(NavRoute.OneTripScreen.route + "/{${Constants.Keys.ID}}"){ backStackEntry ->
            OneTripScreen(
                navController = navController,
                viewModel = viewModel,
                tripId = backStackEntry.arguments?.getString(Constants.Keys.ID)
            )
        }


    }
}