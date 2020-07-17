package com.relatoriodecelula

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.relatoriodecelula.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar.*

class MainActivity : AppCompatActivity() {

    private val calendar = getInstance()
    private val year = calendar.get(YEAR)
    private val month = calendar.get(MONTH)
    private val day = calendar.get(DATE)
    private var week = 1
    private lateinit var takeDatePickerDialog: DatePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        btSend.setOnClickListener {
            sendCellToFirebase(getCellData())
        }
        btShowCalendar.setOnClickListener {
            takeCellDate()
            takeDatePickerDialog.show()
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

    private fun sendCellToFirebase(cell: CelulaBO) {
        cell.leader?.let {
            FirebaseApi().getReference(it).child(calendar.get(MONTH).toString())
                .child(week.toString())
        }?.setValue(cell)
        clearAllFields()
    }

    private fun clearAllFields() {
        etLeader.text = null
        etMembers.text = null
        etVisit.text = null
        etRegulars.text = null
        btShowCalendar.text = getString(R.string.selecione_a_data_da_celula)
    }

    private fun getCellData(): CelulaBO {
        val cell = CelulaBO()
        cell.leader = etLeader.text.toString()
        cell.members = etMembers.text.toString()
        cell.visitors = etVisit.text.toString()
        cell.regulars = etRegulars.text.toString()

        return cell
    }
}