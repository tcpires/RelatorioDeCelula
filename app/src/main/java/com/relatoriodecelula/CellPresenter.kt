package com.relatoriodecelula

class CellPresenter : SearchCellContract.Presenter {

    lateinit var view: SearchCellContract.View
    private val repository = CellRepositoryImpl()

    override fun checkIfLeaderIsNotEmpty(leader: String): Boolean {
        if (leader.isNullOrEmpty()){
            view.showErrorDialog("usário Invalido")
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