package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class CalculatorViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
        get() = _data

    var clear = "0"

    init {
        _result.value = " "
        _data.value=" "
    }


    fun calculation() {

        val operator = _data.value.toString().filterNot { x -> x.isDigit() }
        val operands = _data.value.toString().split("+", "-", "*", "/")
        val arr = operands.map { it.toFloat() }.toTypedArray()
        var res = arr[0].toFloat()
        val err = "NotDefined"
        var check = false
        var count = 1

        //Make it more efficient till 5 digits..
        for (op in operator) {
            when (op) {
                '+' -> res += arr[count++]
                '-' -> res -= arr[count++]
                '*' -> res *= arr[count++]
                '/' -> {
                    if (arr[count] != 0.0F) res /= arr[count++]
                    else {
                        check = true
                        break
                    }
                }
            }
        }
        if (check) _result.value = err
        else _result.value = res.toString()
    }

    //Operation string Checking Function..
    fun checkingOp(data: String): Boolean {
        if (data.isNotEmpty()) {
            val lastLetter = data[data.length - 1]
            return !(lastLetter == '+' || lastLetter == '-'
                    || lastLetter == '*' || lastLetter == '/' || lastLetter == '=')
        } else return false
    }

     fun firstLetterCheck(data: String): Boolean {
        return if (data.isNullOrEmpty()) false
        else !(data[0] == '+' || data[0] == '-' || data[0] == '*' || data[0] == '/')
    }

    fun SetText(ch: Char) {
        if(ch!='C') {
            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                if (firstLetterCheck(_data.value.toString())) {
                    if (checkingOp(_data.value.toString())) {
                        _data.value = "${_data.value.toString()}$ch"
                    }
                }
            } else
                _data.value = "${_data.value.toString()}$ch"
        }
        else
            _data.value=" "
            _result.value=" "
    }

}