package com.relatoriodecelula

import com.google.firebase.database.DataSnapshot

class CelulaMapper {
    private val cell = CelulaBO()
    private val cellsOnMonth = ArrayList<CelulaBO>()

    fun mapCellsOnMonth(snapshot: DataSnapshot, month: String): ArrayList<CelulaBO> {

        for (celula: DataSnapshot in snapshot.children) {
            cell.leader = celula.child("leader").value.toString()
            cell.members = celula.child("members").value.toString()
            cell.visitors = celula.child("visitors").value.toString()
            cell.month = month
            cell.week = celula.key.toString()

            cellsOnMonth.add(cell)
        }

        return cellsOnMonth
    }

}