package com.example.work_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    val Items = arrayListOf<items>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        InitData()
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ItemsAdapter(Items)

    }

    private fun InitData(){
        Items.add(items().apply{
            title = "北碚1"
            content = "西南大学没有疫情"
            image = R.mipmap.login
        })
        Items.add(items().apply{
            title = "北碚2"
            content = "西南大学没有疫情"
            image = R.mipmap.login
        })
        Items.add(items().apply{
            title = "北碚3"
            content = "西南大学没有疫情"
            image = R.mipmap.login
        })

    }
}