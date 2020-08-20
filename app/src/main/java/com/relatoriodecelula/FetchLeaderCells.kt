package com.relatoriodecelula

import com.google.firebase.database.*

class FetchLeaderCells : CellCallBackInterface {
    private lateinit var reference: DatabaseReference
    private lateinit var query: Query
    private val mapper: CelulaMapper = CelulaMapper()

    fun getCellsPerMonth(cellBO: CelulaBO, callback: (List<CelulaBO>) -> Unit) {
        val leader = cellBO.leader
        val month = cellBO.month
        reference = FirebaseApi().getReference(leader).child(month)
        query = reference.orderByChild(month)
        cellListener(month, callback)
    }

    private fun cellListener(month: String, callback: (List<CelulaBO>) -> Unit) {
        var cellList = ArrayList<CelulaBO>()
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.let {
                    cellList = mapper.mapCellsOnMonth(snapshot, month)
                    callback.invoke(cellList)
                }
            }
        })
    }
}