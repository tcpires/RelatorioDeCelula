package com.relatoriodecelula

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CelulaBO(
    var leader: String? = null,
    var members: String? = null,
    var visitors: String? = null,
    var regulars: String? = null,
    var week: Int? = null,
    var month: Int? = null,
    var juveniles: String? = null,
    var kids: String? = null
) : Parcelable
