package com.github.diosa.smarthome.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.github.diosa.smarthome.data.convert.RoomTypeConverter
import com.github.diosa.smarthome.data.entities.nodes.AirConditioner
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom
import kotlinx.coroutines.flow.Flow

@Dao
@TypeConverters(RoomTypeConverter::class)
interface RoomDao {
    @Query("SELECT * FROM rooms")
    fun getAll(): Flow<List<AbstractRoom>>

    @Query("SELECT * FROM rooms WHERE id IN (:roomsIds)")
    fun getAllByIds(roomsIds: IntArray): List<AbstractRoom>

    @Query(
        "SELECT * FROM rooms " +
        "JOIN air_conditioners ON rooms.id = air_conditioners.room_id"
    )
    fun loadRoomAndAllAirConditioners(): Map<AbstractRoom, List<AirConditioner>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg livingRooms: AbstractRoom)

    @Delete
    suspend fun deleteAll(vararg livingRooms: AbstractRoom)

}
