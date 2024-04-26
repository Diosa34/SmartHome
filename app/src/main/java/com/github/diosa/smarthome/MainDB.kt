package com.github.diosa.smarthome

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.github.diosa.smarthome.data.dao.RoomDao
import com.github.diosa.smarthome.data.entities.nodes.AirConditioner
import com.github.diosa.smarthome.data.entities.rooms.AbstractRoom


@Database(
    entities = [
        AbstractRoom::class, AirConditioner::class
    ],
    version = 2, exportSchema = false
)
abstract class MainDB : RoomDatabase() {
    abstract val dao: RoomDao

    companion object{
        fun createDataBase(context: Context): MainDB{
            return databaseBuilder(
                context,
                MainDB::class.java,
                "smart_home"
            ).build()
        }
    }
}