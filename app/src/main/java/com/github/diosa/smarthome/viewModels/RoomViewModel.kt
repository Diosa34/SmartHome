package com.github.diosa.smarthome.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.diosa.smarthome.App
import com.github.diosa.smarthome.MainDB
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom
import com.github.diosa.smarthome.data.entities.types.RoomType
import kotlinx.coroutines.launch

class RoomViewModel(private val database: MainDB) : ViewModel()  {

    var roomName by mutableStateOf("")
    var roomType: RoomType by mutableStateOf(RoomType.LIVING_ROOM)

    val roomsList = database.dao.getAll()

    fun insertRoom() = viewModelScope.launch {
        database.dao.insertAll(
            AbstractRoom(title = roomName, type = roomType, temperature = 25f, humidityPercentage = 60f,
                lightningPercentage = 100f)
        )
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return RoomViewModel(database) as T
            }
        }
    }
}