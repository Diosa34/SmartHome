package com.github.diosa.smarthome.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.diosa.smarthome.R
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom
import com.github.diosa.smarthome.ui.theme.Orange

@Composable
fun MainCard(
    room: AbstractRoom
) {
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
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "im3",
//                            tint = Color.Gray
                    )
                }
            }


            Text(
                text = room.title,
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
                    text = room.temperature.toString() + "ºC",
                    style = TextStyle(fontSize = 32.sp),
                    color = Color.DarkGray
                )
                Text(
                    text = room.humidityPercentage.toString() + "%",
                    style = TextStyle(fontSize = 32.sp),
                    color = Color.DarkGray
                )
            }
        }
    }
}