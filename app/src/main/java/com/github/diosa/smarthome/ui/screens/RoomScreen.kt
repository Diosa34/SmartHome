package com.github.diosa.smarthome.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.diosa.smarthome.R
import com.github.diosa.smarthome.cards.LightingCard
import com.github.diosa.smarthome.cards.MainCard
import com.github.diosa.smarthome.viewModels.RoomViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.diosa.smarthome.cards.ConditionCard
import com.github.diosa.smarthome.cards.MusicCard
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom

@Composable
fun RoomScreen(
    roomId: Int,
    moveToAllRooms: () -> Unit
) {
    Image(
        painter = painterResource(id = R.drawable.living_room),
        contentDescription = "im1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.3f),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {

        MainCard(roomId, moveToAllRooms)
        LightingCard(roomId)
        ConditionCard()
        MusicCard()
        }
}

