package com.relatoriodecelula

import com.google.firebase.database.*

class CellRepositoryImpl : CellRepository{
    private lateinit var query: Query
    private val mapper: CelulaMapper = CelulaMapper()
    private lateinit var reference: DatabaseReference

    override fun getCellsPerMonth(
        leader: String,
        month: String,
        isSuccessful: (List<CelulaBO>) -> Unit,
        isFailure: (String) -> Unit
    ) {
        reference = FirebaseApi().getReference(leader).child(month)
        query = reference.orderByChild(month)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                isFailure.invoke(error.message)
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.let {
                    val cellList  = mapper.mapCellsOnMonth(snapshot, month)
                    isSuccessful.invoke(cellList)
                }
            }
        })
    }

}