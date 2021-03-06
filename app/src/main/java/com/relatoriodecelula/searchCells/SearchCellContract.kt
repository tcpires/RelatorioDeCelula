package com.relatoriodecelula.searchCells

import com.relatoriodecelula.CelulaBO

interface SearchCellContract {

    interface View {
        fun showErrorDialog(message: String)
        fun showCellList(listCell: List<CelulaBO>)
    }

    interface Presenter {
        fun checkIfLeaderIsNotEmpty(leader: String): Boolean
        fun fetchCellList(leader: String, month: String)
    }
}