package com.example.healthassistant.ui.main

import android.os.Bundle
import com.example.healthassistant.databinding.ActivityMainBinding
import com.github.mustafaozhan.basemob.activity.BaseVBActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseVBActivity<ActivityMainBinding>(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: AndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    override fun bind() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun performDI() = AndroidInjection.inject(this)


}
