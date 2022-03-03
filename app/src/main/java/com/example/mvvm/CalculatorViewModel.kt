package com.example.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class CalculatorViewModel(): ViewModel() {


     fun calculation(data: String): String {
        val operator = data.filterNot { x -> x.isDigit() }
        val operands = data.split("+", "-", "*", "/")
        val arr = operands.map { it.toFloat() }.toTypedArray()
        var res = arr[0].toFloat()
        val err = "NotDefined"
        var count = 1
        //Make it more efficient till 5 digits..
        for (op in operator) {
            when (op) {
                '+' -> res += arr[count++]
                '-' -> res -= arr[count++]
                '*' -> res *= arr[count++]
                '/' -> {
                    if (arr[count] != 0.0F) res /= arr[count++]
                    else return err
                }
            }
        }
        return res.toString()
    }

    //Operation string Checking Function..
     fun checkingOp(data: String): Boolean {
        if (data.length >=1) {
            val lastLetter = data[data.length - 1]
            return !(lastLetter == '+' || lastLetter == '-'
                    || lastLetter == '*' || lastLetter == '/' || lastLetter == '=')
        } else return false
    }

     fun firstLetterCheck(data: String): Boolean {
        if( data.isNullOrEmpty()) return false
        else if(data[0] == '+' || data[0] == '-' || data[0] == '*' || data[0] == '/') return false
        else return true
    }
    private fun SetText(data: String, ch: Char): String {
        return "$data$ch"
    }
}