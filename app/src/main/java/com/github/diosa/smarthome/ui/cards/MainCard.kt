package com.github.diosa.smarthome.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.diosa.smarthome.R
import com.github.diosa.smarthome.SmartHomeScreens
import com.github.diosa.smarthome.ui.theme.Orange
import com.github.diosa.smarthome.viewModels.RoomViewModel

@Composable
fun MainCard(
    roomId: Int,
    moveToAllRooms: () -> Unit
) {
    val viewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
    viewModel.getById(roomId)
    val currRoom = viewModel.currRoom.value

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Orange

        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "back",
                    modifier = Modifier
                        .alpha(1f)
                        .size(28.dp)
                        .clickable {
                            moveToAllRooms()
                        }
                )
            }


            Text(
                text = currRoom.title,
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 16.dp
                ),
                style = TextStyle(fontSize = 32.sp),
                color = Color.DarkGray
            )



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Температура",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.DarkGray
                )
                Text(
                    text = "Влажность",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.DarkGray
                )
            }



            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = currRoom.temperature.toString() + "ºC",
                    style = TextStyle(fontSize = 32.sp),
                    color = Color.DarkGray
                )
                Text(
                    text = currRoom.humidityPercentage.toString() + "%",
                    style = TextStyle(fontSize = 32.sp),
                    color = Color.DarkGray
                )
            }
        }
    }
}

