package com.relatoriodecelula

interface CellCallBackInterface {

    fun getCellList(view: SearchCellsActivity, listCells: ArrayList<CelulaBO>) {
        view.getCellList(listCells)
    }

    fun getCellListPerMonth(view: FetchLeaderCells, cellBO: CelulaBO, callback: (List<CelulaBO>) -> Unit){
        view.getCellsPerMonth(cellBO, callback)
    }
}