package com.example.tugasch6.topic3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Barang::class], version = 1,exportSchema = false)
abstract class BarangDatabase : RoomDatabase() {
    abstract fun barangDao() : BarangDAO

    companion object {
        @Volatile
        private var INSTANCE : BarangDatabase? = null
        fun getInstance(context: Context): BarangDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!=null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BarangDatabase::class.java,
                    "my_barang_ch6"
                ).build()
                INSTANCE=instance
                return  instance
            }
        }
    }
}