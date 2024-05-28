package com.github.diosa.smarthome.data.repository;

import androidx.lifecycle.LiveData
import com.github.diosa.smarthome.data.dao.RoomDao
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RoomRepository(private val roomDao: RoomDao) {
    fun getById(id: Int): Flow<AbstractRoom> {
        val room: Flow<AbstractRoom> = roomDao.getById(id)
        println(room)
        return room
    }

    fun getAll(): Flow<List<AbstractRoom>> {
        return roomDao.getAll()
    }

    suspend fun insertAll(vararg rooms: AbstractRoom) {
        return roomDao.insertAll(*rooms)
    }
    suspend fun updateAll(vararg rooms: AbstractRoom) {
        return roomDao.updateAll(*rooms)
    }
}
