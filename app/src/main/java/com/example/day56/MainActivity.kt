package com.example.day56

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mJump.setOnClickListener {
            ActualJump()
        }
        //使用微信分享
        mShare.setOnClickListener {
            Intent().apply {
                val wetalkresult = add1.text.toString().toInt()+add2.text.toString().toInt()
                action = "cu.action.chat"
                data = Uri.parse("content:谢谢分享，你要的结果为：$wetalkresult")
                startActivityForResult(this,456)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123){
            mResult.text = data?.getIntExtra("result",0).toString()
        }else if(requestCode == 456){
           data?.getStringExtra("shareResult").also {
               Toast.makeText(this,it,Toast.LENGTH_LONG).show()
           }
        }
    }

    fun ActualJump() {

            Intent().apply {
                putExtra("first", add1.text.toString().toInt())
                putExtra("second", add2.text.toString().toInt())
                setClass(this@MainActivity, SecondActivity::class.java)
                startActivityForResult(this, 123)
            }
        }


}

