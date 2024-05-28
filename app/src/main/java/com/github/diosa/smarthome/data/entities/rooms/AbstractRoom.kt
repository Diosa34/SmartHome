package com.github.diosa.smarthome.data.entities.rooms

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.github.diosa.smarthome.data.convert.RoomTypeConverter
import com.github.diosa.smarthome.data.entities.types.RoomType

@Entity(tableName = "rooms")
@TypeConverters(RoomTypeConverter::class)
class AbstractRoom(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "type") var type: RoomType = RoomType.LIVING_ROOM,
    @ColumnInfo(name = "temperature") var temperature: Float = 0f,
    @ColumnInfo(name = "humidity_percentage") var humidityPercentage: Float = 0f,
    @ColumnInfo(name = "lightning_percentage") var lightningPercentage: Float = 0f,
//    val musicStation: MusicStationUiState?,
//    val airConditionerList: List<AirConditionerUiState>,
)