package com.relatoriodecelula.registerCells

import com.relatoriodecelula.CelulaBO
import com.relatoriodecelula.CelulaMapper

class RegisterPresenter : RegisterContract.Presenter {

    lateinit var view : RegisterContract.View
    private var repository =
        RegisterRepositoryImpl()
    private var mapper = CelulaMapper()

    override fun registerCell(cell: CelulaBO, month: String, week: String) {
        repository.saveCellOnFirebase(cell, month, week)
        view.showRegisterSuccessMessage("Célula Registrada")
    }

    override fun getCellData(leader: String, members: String, visitors: String, regulars: String): CelulaBO {
       return mapper.mapCell(leader, members, visitors, regulars)
    }
}