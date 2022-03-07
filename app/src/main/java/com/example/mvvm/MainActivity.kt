package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        binding.inputTxt.showSoftInputOnFocus=false

        val viewModel=ViewModelProvider(this)[CalculatorViewModel::class.java]

        //One option is making Custom keyBoard.....
       //The other one is presented as.....

        binding.addBtn.setOnClickListener {    viewModel.SetText('+')    }
        binding.multiplyBtn.setOnClickListener {    viewModel.SetText('*')    }
        binding.minusBtn.setOnClickListener {    viewModel.SetText('-')    }
        binding.div.setOnClickListener {    viewModel.SetText('/')    }
        binding.one.setOnClickListener {
            viewModel.SetText('1')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.two.setOnClickListener {
            viewModel.SetText('2')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.three.setOnClickListener {
            viewModel.SetText('3')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.four.setOnClickListener {
            viewModel.SetText('4')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })}
        binding.five.setOnClickListener {
            viewModel.SetText('5')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.six.setOnClickListener {
            viewModel.SetText('6')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.seven.setOnClickListener {
            viewModel.SetText('7')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.eight.setOnClickListener {
            viewModel.SetText('8')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.nine.setOnClickListener {
            viewModel.SetText('9')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.zero.setOnClickListener {
            viewModel.SetText('0')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }
        binding.dotBtn.setOnClickListener {
            viewModel.SetText('.')
            viewModel.data.observe(this, Observer {
                binding.inputTxt.setText(it.toString())
            })
        }

        //Special Operation...
        binding.clear.setOnClickListener {
            viewModel.SetText('C')
        binding.inputTxt.setText("")
        binding.resultTxt.setText(" ")
        }

        binding.equalBtn.setOnClickListener {
            var data:String=" "
            viewModel.data.observe(this, Observer { x->
                data=x
            })
            val temp = data.split("+", "-", "*", "/")
            if(viewModel.firstLetterCheck(data)){
                if (!(data.isEmpty()) && viewModel.checkingOp(data)) {
                    viewModel.calculation()
                    viewModel.result.observe(this, Observer {
                        binding.resultTxt.text = it.toString()
                    })
                    binding.inputTxt.setText(data.toString())
                }
            }
         }


    }


}