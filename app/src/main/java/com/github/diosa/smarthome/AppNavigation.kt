package com.github.diosa.smarthome

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom
import com.github.diosa.smarthome.data.entities.types.RoomType
import com.github.diosa.smarthome.ui.screens.RoomScreen
import com.github.diosa.smarthome.ui.screens.AllRooms
import com.github.diosa.smarthome.ui.forms.AddRoom
import com.github.diosa.smarthome.viewModels.RoomViewModel

enum class SmartHomeScreens(@StringRes val title: Int) {
    AllRooms(title = R.string.all_rooms),
    AddRoom(title = R.string.add_room),
    RoomScreen(title = R.string.room_screen),
    RoomCard(title = R.string.room_card)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartHomeAppBar(
    currentScreen: SmartHomeScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text("") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}

@Composable
fun SmartHomeNavigation(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = SmartHomeScreens.valueOf(
        backStackEntry?.destination?.route ?: SmartHomeScreens.AllRooms.name
    )
    var room = AbstractRoom(null, "Начальная комната", RoomType.LIVING_ROOM, 0f, 0f, 0f)

    Scaffold(
        topBar = {
            SmartHomeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
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
                    {navController.navigate(SmartHomeScreens.AddRoom.name)},
                {nextRoom ->
                    room = nextRoom
                    navController.navigate(SmartHomeScreens.RoomScreen.name) }
                )
            }
            composable(route = SmartHomeScreens.AddRoom.name) {
                AddRoom {
                    navController.navigate(SmartHomeScreens.AllRooms.name)
                }
            }
            composable(route = SmartHomeScreens.RoomScreen.name) {
                RoomScreen(room)
            }
        }
    }
}