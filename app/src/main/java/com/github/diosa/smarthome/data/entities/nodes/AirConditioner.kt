package com.github.diosa.smarthome.data.entities.nodes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "air_conditioners")
data class AirConditioner(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "room_id") var roomId: Int?,
    @ColumnInfo(name = "isActive") var isActive: Boolean = true,
    var temperature: Float = 25f,
)