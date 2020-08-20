package com.relatoriodecelula

import java.time.Month

interface CellRepository {
    fun getCellsPerMonth(
        leader : String,
        month: String,
        isSuccessful: (List<CelulaBO>) -> Unit,
        isFailure: (String) -> Unit
    )
}