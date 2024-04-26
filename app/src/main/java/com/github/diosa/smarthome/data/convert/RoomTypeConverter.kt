package com.github.diosa.smarthome.data.convert

import androidx.room.TypeConverter
import com.github.diosa.smarthome.data.entities.types.RoomType

class RoomTypeConverter {
    @TypeConverter
    fun toRoomType(value: String) = enumValueOf<RoomType>(value)

    @TypeConverter
    fun fromRoomType(value: RoomType) = value.name
}