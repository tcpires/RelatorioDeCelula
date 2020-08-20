package com.relatoriodecelula

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.relatoriodecelula.databinding.ActivitySearchCellsBinding
import kotlinx.android.synthetic.main.activity_search_cells.*
import java.util.*

class SearchCellsActivity : AppCompatActivity(), CellCallBackInterface {

    private lateinit var takeDatePickerDialog: DatePickerDialog
    private val calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)
    private var month = calendar.get(Calendar.MONTH)
    private val day = calendar.get(Calendar.DATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySearchCellsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_search_cells)

        search_cell_button.setOnClickListener {
            getCellListPerMonth(FetchLeaderCells(), getCellBO())
        }
        btShowCalendar.setOnClickListener {
            takeCellMonth()
            takeDatePickerDialog.show()
        }
    }

    fun getCellList(listCells: ArrayList<CelulaBO>) {
        updateAdapter(listCells)
    }

    private fun updateAdapter(listCells: ArrayList<CelulaBO>) {
        val adapter = CellReportAdapter(listCells)
        val layoutManager = LinearLayoutManager(this)

        val rv = findViewById<RecyclerView>(R.id.rvCellList)
        rv.visibility = VISIBLE
        rv.adapter = adapter
        rv.layoutManager = layoutManager

    }

    private fun getCellBO(): CelulaBO {
        val params = CelulaBO()
        val month = this.month.toString()
        params.month = month
        params.leader = etLeaderSearch.text.toString()
        return params
    }

    private fun takeCellMonth() {
        takeDatePickerDialog =
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                if (calendar.get(Calendar.MONTH) != Calendar.JANUARY) {
                    calendar.set(year, month + 1, day)
                } else {
                    calendar.set(year, month, day)
                }
                this.month = calendar.get(Calendar.MONTH)
            }, year, month, day)
    }

}