package com.relatoriodecelula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.relatoriodecelula.databinding.ActivitySearchCellsBinding
import kotlinx.android.synthetic.main.activity_search_cells.*

class SearchCellsActivity : AppCompatActivity(), CellCallBackInterface {

    private var cellList: ArrayList<CelulaBO> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:  ActivitySearchCellsBinding=
            DataBindingUtil.setContentView(this, R.layout.activity_search_cells)

        search_cell_button.setOnClickListener {
            getCellListPerMonth(FetchLeaderCells())
        }
    }

    fun getCellList(listCells: ArrayList<CelulaBO>): ArrayList<CelulaBO> {
        cellList = listCells
        return cellList
    }

    fun passSearchParams(): CelulaBO {
        var params: CelulaBO = CelulaBO()
        val leader: String = "Diego Dimitri"
        val month: String = "5"

        params.leader = leader
        params.month = month

        return params

    }
}