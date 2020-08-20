package com.relatoriodecelula

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.relatoriodecelula.databinding.ActivitySearchCellsBinding
import kotlinx.android.synthetic.main.activity_search_cells.*
import java.util.*

class SearchCellsActivity : AppCompatActivity(), SearchCellContract.View {

    private lateinit var takeDatePickerDialog: DatePickerDialog
    private val calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)
    private var month = calendar.get(Calendar.MONTH)
    private val day = calendar.get(Calendar.DATE)
    private val presenter = CellPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySearchCellsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_search_cells)

        presenter.view = this

        search_cell_button.setOnClickListener {
            val month = this.month.toString()
            val leader = etLeaderSearch.text.toString()
            presenter.fetchCellList(leader, month)
        }

        btShowCalendar.setOnClickListener {
            takeCellMonth()
            takeDatePickerDialog.show()
        }
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

    override fun showErrorDialog(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showCellList(listCell: List<CelulaBO>) {
        val adapter = CellReportAdapter(listCell)
        val rv = findViewById<RecyclerView>(R.id.rvCellList)
        rv.visibility = VISIBLE
        rv.adapter = adapter
    }

}