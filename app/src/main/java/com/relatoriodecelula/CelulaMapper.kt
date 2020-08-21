package com.relatoriodecelula

import com.google.firebase.database.DataSnapshot

class CelulaMapper {

    fun mapCellsOnMonth(
        snapshot: DataSnapshot,
        month: String,
        leader: String
    ): MutableList<CelulaBO> {
        val cellsOnMonth: MutableList<CelulaBO> = ArrayList()

        for (celula in snapshot.children) {
            if (celula.key?.contains(leader)!!) {
                for (week in celula.children) {
                    val cell = CelulaBO()
                    cell.leader = week.child("leader").value.toString()
                    cell.members = week.child("members").value.toString()
                    cell.visitors = week.child("visitors").value.toString()
                    cell.regulars = week.child("regulars").value.toString()
                    cell.month = month
                    cell.week = (week.key?.toInt()?.plus(1)).toString()
                    cellsOnMonth.add(cell)
                }
            }
        }
        return cellsOnMonth
    }

    fun mapCell(leader: String,
                members: String,
                visitors: String,
                regulars: String): CelulaBO {
        val cell = CelulaBO()
        cell.leader = leader
        cell.members = members
        cell.visitors = visitors
        cell.regulars = regulars

        return cell
    }
}

