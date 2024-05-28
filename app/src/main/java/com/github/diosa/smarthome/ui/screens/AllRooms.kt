package com.github.diosa.smarthome.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.diosa.smarthome.viewModels.RoomViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.diosa.smarthome.R
import com.github.diosa.smarthome.SmartHomeScreens
import com.github.diosa.smarthome.ui.cards.RoomCard

@Composable
fun AllRooms(
    navController: NavController
) {
    val viewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
    val itemsList = viewModel.roomsList.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Мои комнаты",
                style = TextStyle(fontSize = 24.sp),
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.add_circle),
                contentDescription = "add new room",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.navigate(SmartHomeScreens.AddRoom.name)
                    }
            )
        }
        Column {
            if (itemsList.isNotEmpty()) {
                for (item in itemsList) {
                    RoomCard(room = item) {
                        navController.navigate((SmartHomeScreens.RoomScreen.name) + "/${item.id}")
                    }
                }
            }
        }
    }

}
