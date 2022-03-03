package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Implementation of the logic and code.....

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        title = "CALCULATOR"
        setContentView(binding.root)


        val viewModel=ViewModelProvider(this)[CalculatorViewModel::class.java]

        //Buttons for Operations..

        binding.addBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (viewModel.firstLetterCheck(data)) {
                if (viewModel.checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '+')
                } else binding.resultTxt.text = data
            }
        }
        binding.minusBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (viewModel.firstLetterCheck(data)) {
                if (viewModel.checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '-')
                } else binding.resultTxt.text = data
            }
        }
        binding.divBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (viewModel.firstLetterCheck(data)) {
                if (viewModel.checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '/')
                } else binding.resultTxt.text = data
            }
        }
        binding.multiplyBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            if (viewModel.firstLetterCheck(data)) {
                if (viewModel.checkingOp(data)) {
                    binding.resultTxt.text = SetText(data, '*')
                } else binding.resultTxt.text = data
            }
        }

        //Buttons For Special Operations...
        binding.equalBtn.setOnClickListener {
            val data = binding.resultTxt.text.toString()
            //Calculation Logic...
            val temp = data.split("+", "-", "*", "/")
            if(viewModel.firstLetterCheck(data)) {
                if (temp.size > 1) {
                    if (!(data.isNullOrEmpty()) && viewModel.checkingOp(data) == true) {
                        binding.resultTxt.text = viewModel.calculation(data)
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
             val data=binding.resultTxt.text.toString()
            binding.resultTxt.setText(SetText(data,'.'))
        }

    }

    //Calculations....


    //Func. for String Concatenation...
    private fun SetText(data: String, ch: Char): String {
        return "$data$ch"
    }

}