package com.example.yifan_fetch_th

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yifan_fetch_th.ui.main.SelectionFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SelectionFragment.newInstance())
                .commitNow()
        }*/
    }

}