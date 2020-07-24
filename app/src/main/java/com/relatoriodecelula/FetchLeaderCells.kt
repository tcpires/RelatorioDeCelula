package com.relatoriodecelula

import com.google.firebase.database.*

class FetchLeaderCells {
    private lateinit var reference: DatabaseReference
    private lateinit var query: Query
    private val mapper: CelulaMapper = CelulaMapper()
    private var cellList: List<CelulaBO> = listOf()

    fun getCellsPerMonth(leader: String, month: String){
        reference = FirebaseApi().getReference(leader).child(month)
        query = reference.orderByChild(month)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
            override fun onDataChange(snapshot: DataSnapshot) {
               cellList =  mapper.mapCellsOnMonth(snapshot, month)
            }
        })
    }
}