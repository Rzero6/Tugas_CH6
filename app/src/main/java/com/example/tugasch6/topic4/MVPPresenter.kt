package com.example.tugasch6.topic4

import com.example.tugasch6.topic3.Barang

interface MVPPresenter {
    fun addData(barang: Barang)
    fun removeData(index : Int)
    fun getData()
    fun updData(barang: Barang)
}