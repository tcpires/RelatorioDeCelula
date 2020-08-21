package com.relatoriodecelula.searchCells

import com.relatoriodecelula.CelulaBO

class SearchCellPresenter : SearchCellContract.Presenter {

    lateinit var view: SearchCellContract.View
    private val repository = SearchCellRepositoryImpl()

    override fun checkIfLeaderIsNotEmpty(leader: String): Boolean {
        if (leader.isNullOrEmpty() || leader == " "){
            view.showErrorDialog("O campo Lider deve ser preenchido")
            return false
        }
        return true
    }

    override fun fetchCellList(leader: String, month: String) {

        val successfulCallback : (List<CelulaBO>) -> Unit = {
            view.showCellList(it)
        }

        val failureCallback : (String) -> Unit = {
            view.showErrorDialog(it)
        }

        repository.getCellsPerMonth(leader, month, successfulCallback, failureCallback)
    }
}