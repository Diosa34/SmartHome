package com.github.diosa.smarthome.ui.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.diosa.smarthome.R
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom

@Composable
fun RoomCard(
    room: AbstractRoom,
    onNextRoomClicked: (AbstractRoom) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column (
            modifier = Modifier
                .weight(2f)
                .padding(8.dp),
        ) {
            Text(
                text = room.title,
                style = TextStyle(fontSize = 20.sp),
                color = Color.DarkGray
            )
            Text(
                text = room.type.value,
                style = TextStyle(fontSize = 12.sp),
                color = Color.DarkGray
            )
        }
        Image(
            painter = painterResource(id = R.drawable.next_page),
            contentDescription = "next",
            modifier = Modifier
                .alpha(0.7f)
                .size(32.dp)
                .clickable {
                    onNextRoomClicked(room)
                }
        )
    }
}
