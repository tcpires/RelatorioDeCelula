package com.relatoriodecelula.searchCells

import com.google.firebase.database.*
import com.relatoriodecelula.CelulaBO
import com.relatoriodecelula.CelulaMapper
import com.relatoriodecelula.FirebaseApi

class SearchCellRepositoryImpl :
    SearchCellRepository {
    private val mapper: CelulaMapper = CelulaMapper()
    private lateinit var reference: DatabaseReference

    override fun getCellsPerMonth(
        leader: String,
        month: String,
        isSuccessful: (List<CelulaBO>) -> Unit,
        isFailure: (String) -> Unit
    ) {
        reference = FirebaseApi().getReference(month)
        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                isFailure.invoke(error.message)
            }
            override fun onDataChange(snapshot: DataSnapshot) {

                snapshot.let {
                    val cellList  = mapper.mapCellsOnMonth(snapshot, month, leader)
                    isSuccessful.invoke(cellList)
                }
            }
        })
    }
}