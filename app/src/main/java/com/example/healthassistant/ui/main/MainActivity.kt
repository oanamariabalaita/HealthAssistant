package com.example.healthassistant.ui.main

import android.os.Bundle
import com.example.healthassistant.R
import com.example.healthassistant.base.BaseActivity
import com.example.healthassistant.base.BaseViewModel

class MainActivity : BaseActivity<BaseViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getLayoutResId(): Int? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
