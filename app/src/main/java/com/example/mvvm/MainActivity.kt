package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Implementation of the logic and code.....

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        title = "CALCULATOR"
        setContentView(binding.root)

        //Buttons for Operations..
        binding.addBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (firstLetterCheck(data)) {
                if (checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '+')
                } else binding.resultTxt.text = data
            }
        }
        binding.minusBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (firstLetterCheck(data)) {
                if (checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '-')
                } else binding.resultTxt.text = data
            }
        }
        binding.divBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (firstLetterCheck(data)) {
                if (checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '/')
                } else binding.resultTxt.text = data
            }
        }
        binding.multiplyBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (firstLetterCheck(data)) {
                if (checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '*')
                } else binding.resultTxt.text = data
            }
        }

        //Buttons For Special Operations...
        binding.equalBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            //Calculation Logic...
            val temp = data.split("+", "-", "*", "/")
            if(firstLetterCheck(data)) {
                if (temp.size > 1) {
                    if (!(data.isNullOrEmpty()) && checkingOp(data) == true) {
                        binding.resultTxt.text = calculation(data)
                        binding.inputTxt.text = data
                    }
                }
            }
        }
        binding.clearBtn.setOnClickListener {
            binding.resultTxt.text = null
            binding.inputTxt.text = null
        }


        //Buttons for numbers...
        binding.zeroBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '0')
        }
        binding.oneBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '1')
        }
        binding.twoBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '2')
        }
        binding.threeBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '3')
        }
        binding.fourBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '4')
        }
        binding.fiveBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '5')
        }
        binding.sixBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '6')
        }
        binding.sevenBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '7')
        }
        binding.eightBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '8')
        }
        binding.nineBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            binding.resultTxt.text = SetText(data, '9')
        }
        binding.dotBtn.setOnClickListener {
            // val data=binding.resultTxt.text.toString()
            //   binding.resultTxt.setText(SetText(data,'.'))
            Toast.makeText(applicationContext, "Not Implemented yet.", Toast.LENGTH_LONG).show()
        }

    }

    //Calculations....

    private fun calculation(data: String): String {
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
    private fun checkingOp(data: String): Boolean {
        if (data.length >=1) {
            val lastLetter = data[data.length - 1]
            return !(lastLetter == '+' || lastLetter == '-'
                    || lastLetter == '*' || lastLetter == '/' || lastLetter == '=')
        } else return false
    }

    private fun firstLetterCheck(data: String): Boolean {
        if( data.isNullOrEmpty()) return false
        else if(data[0] == '+' || data[0] == '-' || data[0] == '*' || data[0] == '/') return false
        else return true
    }

    //Func. for String Concatenation...
    private fun SetText(data: String, ch: Char): String {
        return "$data$ch"
    }

}