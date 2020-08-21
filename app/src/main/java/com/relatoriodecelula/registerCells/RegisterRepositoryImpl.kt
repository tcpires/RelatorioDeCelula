package com.relatoriodecelula.registerCells

import com.relatoriodecelula.CelulaBO
import com.relatoriodecelula.FirebaseApi

class RegisterRepositoryImpl:
    RegisterRepository {
    override fun saveCellOnFirebase(celulaBO: CelulaBO, month: String, week: String) {
        FirebaseApi().getReference(month).child(celulaBO.leader)
            .child(week).setValue(celulaBO)
    }
}