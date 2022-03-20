package com.example.work_1

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "@@MainActivity@@"

    private var username:String? = null
    private var password:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameobj = findViewById<EditText>(R.id._username)
        val passwordobj = findViewById<EditText>(R.id._password)

        val usernameWatcher = object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i(TAG,"beforeTextChanged : $s")
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i(TAG,"onTextChanged : $s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged : $s")
                username = s?.toString()
            }

        }

        val passwordWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i(TAG,"beforeTextChanged : $s")
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i(TAG,"onTextChanged : $s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged : $s")
                password = s?.toString()
            }

        }

        usernameobj.addTextChangedListener(usernameWatcher)
        passwordobj.addTextChangedListener(passwordWatcher)
    }

    fun OnClick(view : View){
        Log.d(TAG,"username = $username")
        Log.d(TAG,"password = $password")

        AlertDialog.Builder(this)
            .setTitle("请确认")
            .setMessage("您确定要登录吗？")
            .setNegativeButton("取消"){d,w->
                Toast.makeText(this,"已取消",Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("确定"){d,w->
                toLogin()
            }
            .show()
    }

    private fun toLogin() {
        val process = findViewById<ProgressBar>(R.id.progressBar)
        process.visibility = View.VISIBLE
        process.progress = 1
        val timer = Timer()
        val content = this
        val task = object : TimerTask() {
            override fun run() {
                Log.d(TAG,"process:${process.progress}")
                process.progress = process.progress + 2
                if(process.progress == 10){
                    timer.cancel()
                    Handler(Looper.getMainLooper()).post{
                        process.visibility = View.GONE
                        startActivity(Intent(content,SecondActivity::class.java))
                    }
                }
            }
        }

        timer.schedule(task,0,1000)
    }

}
