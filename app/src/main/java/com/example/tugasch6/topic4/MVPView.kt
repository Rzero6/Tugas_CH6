package com.example.tugasch6.topic4

import com.example.tugasch6.topic3.Barang

interface MVPView {
    fun showData(data : List<Barang>?)
}