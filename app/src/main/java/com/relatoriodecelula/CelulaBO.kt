package com.relatoriodecelula

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CelulaBO(
    var leader: String = "",
    var members: String = "",
    var visitors: String = "",
    var regulars: String = "",
    var week: String = "",
    var month: String = "",
    var juveniles: String = "",
    var kids: String = ""
) : Parcelable
