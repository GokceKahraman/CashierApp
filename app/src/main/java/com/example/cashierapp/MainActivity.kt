package com.example.cashierapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var calculate_button: Button



    var banknotes = intArrayOf(100, 50, 20, 10, 5,  1)  //all banknotes that we have
    var noteCounter = IntArray(6)
   // var i: Int = noteCounter.size -1;
    var banknotesnumber = 0  //given count of banknotes
    var total = 0
    var spending = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_button = findViewById(R.id.calculate_button)
        calculate_button.setOnClickListener{ view: View ->
            total = Integer.valueOf(totalMoney_TextNumber.text.toString())
            spending = Integer.valueOf(spendingMoney_TextNumber.text.toString())
            calculate()
        }

    }

    fun calculate() {
        var result = (total - spending)
        var remainMoney = result

        //mod
        for (bank in banknotes) {
            if(result >= bank) {
                val banknotes = result/bank
                result %= bank
                banknotesnumber +=banknotes
                if (result == 0)
                    break
            }
        }
        result_textView.text = "Your Payback is ${remainMoney} . The number of banknotes you will get back ${banknotesnumber}"
    }



}