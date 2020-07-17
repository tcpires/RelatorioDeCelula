package com.relatoriodecelula

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseApi {


    fun getReference(reference: String): DatabaseReference{
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        return database.getReference(reference)
    }
}