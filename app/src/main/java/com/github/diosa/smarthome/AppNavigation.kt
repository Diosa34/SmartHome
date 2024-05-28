package com.github.diosa.smarthome

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.diosa.smarthome.ui.screens.RoomScreen
import com.github.diosa.smarthome.ui.screens.AllRooms
import com.github.diosa.smarthome.ui.forms.AddRoom

enum class SmartHomeScreens(@StringRes val title: Int) {
    AllRooms(title = R.string.all_rooms),
    AddRoom(title = R.string.add_room),
    RoomScreen(title = R.string.room_screen),
    RoomCard(title = R.string.room_card)
}


@Composable
fun SmartHomeNavigation(
    navController: NavHostController = rememberNavController()
) {

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SmartHomeScreens.AllRooms.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = SmartHomeScreens.AllRooms.name) {
                AllRooms (
                    navController
                )
            }
            composable(route = SmartHomeScreens.AddRoom.name) {
                AddRoom {
                    navController.navigate(SmartHomeScreens.AllRooms.name)
                }
            }
            composable(
                route = SmartHomeScreens.RoomScreen.name + "/{roomId}",
                arguments = listOf(navArgument("roomId") { type = NavType.IntType })
            ) { backStackEntry ->
                val roomId = backStackEntry.arguments?.getInt("roomId")
                RoomScreen(
                    roomId!!
                ) { navController.navigate(SmartHomeScreens.AllRooms.name) }
            }
        }
    }
}