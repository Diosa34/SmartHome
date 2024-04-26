package com.github.diosa.smarthome.ui.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.diosa.smarthome.viewModels.RoomViewModel

@Composable
fun AddRoom(
    moveToAllRooms: () -> Unit
) {
    val viewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        OutlinedTextField(
            viewModel.roomName,
            modifier= Modifier.padding(8.dp),
            label = { Text("Name") },
            onValueChange = {viewModel.roomName = it})
        Button(
            { viewModel.insertRoom()
              moveToAllRooms()
            },
            Modifier.padding(8.dp))
        {
            Text("Add", fontSize = 22.sp)
        }
    }
}