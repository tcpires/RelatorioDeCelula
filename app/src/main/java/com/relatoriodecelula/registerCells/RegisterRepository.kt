package com.relatoriodecelula.registerCells

import com.relatoriodecelula.CelulaBO

interface RegisterRepository {
    fun saveCellOnFirebase(
        celulaBO: CelulaBO,
        month: String,
        week: String
    )
}