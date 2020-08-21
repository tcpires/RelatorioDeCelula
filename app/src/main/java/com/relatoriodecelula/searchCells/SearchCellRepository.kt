package com.relatoriodecelula.searchCells

import com.relatoriodecelula.CelulaBO

interface SearchCellRepository {
    fun getCellsPerMonth(
        leader : String,
        month: String,
        isSuccessful: (List<CelulaBO>) -> Unit,
        isFailure: (String) -> Unit
    )
}