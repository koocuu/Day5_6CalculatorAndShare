package com.example.day56

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        mBack.setOnClickListener {
            val one = intent.getIntExtra("first", 0)
            val two = intent.getIntExtra("second", 0)
            val result = one + two
            Intent().apply {
                putExtra("result",result)
            }.also {
                setResult(1,it)
            }

            finish()
        }


        mCall.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel:123456")
                startActivity(this)
            }
        }


    }


}


