package com.relatoriodecelula.registerCells

import com.relatoriodecelula.CelulaBO

interface RegisterContract {
    interface View{
        fun showRegisterSuccessMessage(message: String)
    }

    interface Presenter{
        fun registerCell(cell: CelulaBO, month: String, week: String)
        fun getCellData(leader: String, members: String, visitors: String, regulars: String): CelulaBO

    }
}