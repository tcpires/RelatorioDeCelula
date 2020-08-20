package com.relatoriodecelula

interface CellCallBackInterface {

    fun getCellList(view: SearchCellsActivity, listCells: ArrayList<CelulaBO>) {
        view.getCellList(listCells)
    }

    fun getCellListPerMonth(view: FetchLeaderCells, cellBO: CelulaBO){
        view.getCellsPerMonth(cellBO)
    }
}