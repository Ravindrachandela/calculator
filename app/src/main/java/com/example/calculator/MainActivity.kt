package com.example.calculator

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    lateinit var edtnum1: EditText
    lateinit var edtnum2: EditText
    lateinit var plusbtn: ImageView
    lateinit var minusbtn: ImageView
    lateinit var multi: ImageView
    lateinit var divison: ImageView
    lateinit var Result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        plusbtn = findViewById(R.id.plusbtn)
        minusbtn = findViewById(R.id.minusbtn)
        multi = findViewById(R.id.mutibtn)
        divison = findViewById(R.id.divisionbtn)

        plusbtn.setOnClickListener{
            result(it)
        }
        minusbtn.setOnClickListener{
            result(it)
        }
        multi.setOnClickListener{
            result(it)
        }
        divison.setOnClickListener{
            result(it)
        }


    }

    private fun result(v: View) {
        edtnum1 = findViewById(R.id.edtnum1)
        edtnum2 = findViewById(R.id.edtnum2)
        Result = findViewById(R.id.txt)
        var num1: Float
        var num2: Float
        var res: Float

        if (TextUtils.isEmpty(edtnum1.text.toString())) {
            edtnum1.error = "Enter number please"
            return
        } else {
            num1 = edtnum1.text.toString().toFloat()
        }
        if (TextUtils.isEmpty(edtnum2.text.toString())) {
            edtnum2.error = "Enter number please"
            return
        } else {
            num2 = edtnum2.text.toString().toFloat()
        }
        when (v.id) {
            R.id.plusbtn -> {
                res = num1 + num2
                Result.text = res.toString()
            }

            R.id.minusbtn -> {
                res = num1 - num2
                Result.text = res.toString()
            }

            R.id.mutibtn -> {
                res = num1 * num2
                Result.text = res.toString()
            }

            R.id.divisionbtn -> {
                if (num2 == 0.0F) {
                    edtnum2.error = "can not divide by zero"
                } else {
                    res = num1 / num2
                    Result.text = res.toString()
                }

            }

        }
    }
}



