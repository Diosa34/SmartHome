package com.github.diosa.smarthome.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.diosa.smarthome.App
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom
import com.github.diosa.smarthome.data.entities.types.RoomType
import com.github.diosa.smarthome.data.repository.RoomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RoomViewModel(private val repository: RoomRepository) : ViewModel()  {

    var roomTitle by mutableStateOf("")
    var roomType: RoomType by mutableStateOf(RoomType.LIVING_ROOM)
    var roomTemperature by mutableFloatStateOf(0f)
    var roomHumidityPercentage by mutableFloatStateOf(0f)
    var roomLightningPercentage by mutableFloatStateOf(0f)

    var roomsList = mutableStateOf<List<AbstractRoom>>(emptyList())

    private val _currRoom = mutableStateOf(AbstractRoom())
    val currRoom: State<AbstractRoom> = _currRoom

    init {
        getAll()
    }

    fun getById(id: Int) {
        viewModelScope.launch {
            repository.getById(id).collect { data ->
                _currRoom.value = data
            }
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            repository.getAll().collect { data ->
                roomsList.value = data
            }
        }
    }

    fun updateLightning(value: Float) = viewModelScope.launch {
        _currRoom.value.lightningPercentage = value
        repository.updateAll(
            _currRoom.value
        )
    }

    fun insertRoom() = viewModelScope.launch {
        repository.insertAll(
            AbstractRoom(title = roomTitle, type = roomType, temperature = roomTemperature, humidityPercentage = roomHumidityPercentage,
                lightningPercentage = roomLightningPercentage)
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
                val roomDao = database.dao
                val repository = RoomRepository(roomDao)
                return RoomViewModel(repository) as T
            }
        }
    }
}