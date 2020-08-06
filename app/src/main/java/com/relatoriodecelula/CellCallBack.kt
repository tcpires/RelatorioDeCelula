package com.relatoriodecelula

interface CellCallBackInterface {

    fun getCellList(view: SearchCellsActivity, listCells: ArrayList<CelulaBO>) {
        view.getCellList(listCells)
    }

    fun getSearchParams(view: SearchCellsActivity): CelulaBO {
        return view.passSearchParams()
    }

    fun getCellListPerMonth(view: FetchLeaderCells){
        view.getCellsPerMonth()
    }
}