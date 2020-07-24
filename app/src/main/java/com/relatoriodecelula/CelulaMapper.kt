package com.relatoriodecelula

import com.google.firebase.database.DataSnapshot

class CelulaMapper {
    private val cell = CelulaBO()
    private val cellsOnMonth = ArrayList<CelulaBO>()

    fun mapCellsOnMonth(snapshot: DataSnapshot, month: String): ArrayList<CelulaBO> {

        for (celula: DataSnapshot in snapshot.children) {
            cell.leader = celula.child("leader").value as String?
            cell.members = celula.child("members").value as String?
            cell.visitors = celula.child("visitors").value as String?
            cell.month = celula.child(month).value as Int?

            cellsOnMonth.add(cell)
        }

        return cellsOnMonth
    }

}