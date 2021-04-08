package com.example.tugasch6.topic3

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface BarangDAO {
    @Query("SELECT * FROM barang")
    fun getAllBarang(): List<Barang>?

    @Insert
    fun insertBarang(barang: Barang): Long

    @Update
    fun updateBarang(barang: Barang): Int

    @Query("DELETE FROM barang WHERE id= :id")
    fun deleteBarang(id: Int): Int

}