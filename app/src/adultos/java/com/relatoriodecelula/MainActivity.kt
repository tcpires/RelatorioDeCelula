package com.relatoriodecelula

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.relatoriodecelula.databinding.ActivityMainBinding
import com.relatoriodecelula.registerCells.RegisterContract
import com.relatoriodecelula.registerCells.RegisterPresenter
import com.relatoriodecelula.searchCells.SearchCellsActivity
import kotlinx.android.synthetic.adultos.activity_main.*
import java.util.Calendar.*

class MainActivity : AppCompatActivity(), RegisterContract.View {

    private val calendar = getInstance()
    private val year = calendar.get(YEAR)
    private val month = calendar.get(MONTH)
    private val day = calendar.get(DATE)
    private var week = 1
    private lateinit var takeDatePickerDialog: DatePickerDialog
    private val presenter =
        RegisterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        presenter.view = this

        btSend.setOnClickListener {
            presenter.registerCell(
                presenter.getCellData(
                    etLeader.text.toString(),
                    etMembers.text.toString(),
                    etVisit.text.toString(),
                    etRegulars.text.toString()
                ),
                calendar.get(MONTH).toString(),
                week.toString()
            )
            clearAllFields()
        }

        btShowCalendar.setOnClickListener {
            takeCellDate()
            takeDatePickerDialog.show()
        }
        search_cell.setOnClickListener {
            val intent = Intent(this, SearchCellsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun takeCellDate() {
        takeDatePickerDialog =
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                if (calendar.get(MONTH) != JANUARY) {
                    calendar.set(year, month + 1, day)
                } else {
                    calendar.set(year, month, day)
                }
                week = calendar.get(WEEK_OF_MONTH) - 1
                setButtonText()
            }, year, month, day)
    }

    @SuppressLint("SetTextI18n")
    private fun setButtonText() {
        btShowCalendar.text =
            "${calendar.get(DATE)}/${calendar.get(MONTH)}/${calendar.get(YEAR)}"
    }

    private fun clearAllFields() {
        etLeader.text = null
        etMembers.text = null
        etVisit.text = null
        etRegulars.text = null
        btShowCalendar.text = getString(R.string.selecione_a_data_da_celula)
    }

    override fun showRegisterSuccessMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}