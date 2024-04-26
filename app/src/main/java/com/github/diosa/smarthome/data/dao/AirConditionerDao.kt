package com.github.diosa.smarthome.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.github.diosa.smarthome.data.entities.nodes.AirConditioner

@Dao
interface AirConditionerDao {
    @Query("SELECT * FROM air_conditioners")
    fun getAll(): List<AirConditioner>

    @Query("SELECT * FROM air_conditioners WHERE id IN (:airCondIds)")
    fun getAllByIds(airCondIds: IntArray): List<AirConditioner>

    @Query("SELECT * FROM air_conditioners WHERE room_id = (:roomId)")
    fun getAllByRoomId(roomId: Int): List<AirConditioner>

    @Insert
    fun insertAll(vararg airConditioners: AirConditioner)

    @Update
    fun updateAll(vararg airConditioners: AirConditioner)

    @Delete
    fun delete(airConditioner: AirConditioner)
}