package com.example.testtvup.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.testtvup.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_host_fragment)
    }
}