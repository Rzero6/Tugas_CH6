package com.example.tugasch6.topic4

import com.example.tugasch6.topic3.Barang
import com.example.tugasch6.topic3.BarangDAO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MVPPresenterImp (private val view:MVPView, private val barangDAO: BarangDAO) : MVPPresenter{
    override fun addData(barang: Barang) {
        GlobalScope.launch {
            barangDAO.insertBarang(barang)
            getData()
        }
    }

    override fun removeData(index: Int) {
        GlobalScope.launch {
            barangDAO.deleteBarang(index)
            getData()
        }
    }

    override fun getData() {
        GlobalScope.launch {
            val barang = barangDAO.getAllBarang()
            view.showData(barang)
        }
    }

    override fun updData(barang: Barang) {
        GlobalScope.launch {
            barangDAO.updateBarang(barang)
            getData()
        }
    }

}