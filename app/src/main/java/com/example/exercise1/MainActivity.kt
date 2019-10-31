package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            val car_price = editTextCarPrice.text.toString().toInt()
            val downpayment = editTextDownPayment.text.toString().toInt()
            val loan_period = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toDouble()
            //TODO : continue the calculation here
            val loan = car_price - downpayment
            val interest = loan * interest_rate / 100 * loan_period
            val monthly_pay = (loan + interest) / loan_period / 12
            textViewLoan.text = getString(R.string.loan) + "${loan}"
            textViewInterest.text = getString(R.string.Interest) + "${interest}"
            textViewMonthlyPayment.text = getString(R.string.monthly_repayment) + "${monthly_pay}"
        }
    }

    fun resetInputs(view: View) {
        //TODO : reset all inputs and outputs
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
        textViewInterest.text = getString(R.string.Interest)
        textViewLoan.text = getString(R.string.loan)
        textViewMonthlyPayment.text = getString(R.string.monthly_repayment)
    }

    fun showResult(view: View) {
        val carPrice: String = editTextCarPrice.text.toString()
        val downPayment: String = editTextDownPayment.text.toString()
        val loanPeriod: String = editTextLoanPeriod.text.toString()
        val interestRate: String = editTextInterestRate.text.toString()

        if (carPrice.length == 0) {
            editTextCarPrice.setError("Please enter car price")
            return
        }
        if (downPayment.length == 0) {
            editTextDownPayment.setError("Please enter down payment")
            return
        }
        if (loanPeriod.length == 0) {
            editTextLoanPeriod.setError("Please enter loan period")
            return
        }
        if (interestRate.length == 0||interestRate.toDouble() < 0 || interestRate.toDouble() > 100) {
            editTextInterestRate.setError("Please enter interest rate")
            return
        }

    }
}
