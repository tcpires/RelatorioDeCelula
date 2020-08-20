package com.relatoriodecelula

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CellHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val detail = itemView.findViewById(R.id.tv_week_detail_value) as TextView
    val members = itemView.findViewById(R.id.tv_members_detail_value) as TextView
    val visitors = itemView.findViewById(R.id.tv_visitors_detail_value) as TextView
    val regulars = itemView.findViewById(R.id.tv_regulars_detail_value) as TextView

}