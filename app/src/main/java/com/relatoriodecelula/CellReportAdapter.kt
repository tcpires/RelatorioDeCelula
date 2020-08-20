package com.relatoriodecelula

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CellReportAdapter(
    private val cellList: List<CelulaBO>
) : RecyclerView.Adapter<CellHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellHolder {
        return CellHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_cell_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return cellList.size
    }

    override fun onBindViewHolder(holder: CellHolder, position: Int) {
        holder.detail.text = cellList[position].week.toString()
        holder.members.text = cellList[position].members
        holder.visitors.text = cellList[position].visitors
        holder.regulars.text = cellList[position].regulars
    }
}