package com.example.tugasch6.topic3

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "barang")
@Parcelize
data class Barang(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "nama")
    var nama: String,

    @ColumnInfo(name = "warna")
    var warna: String,

    @ColumnInfo(name = "jumlah")
    var jumlah: Int
) : Parcelable
