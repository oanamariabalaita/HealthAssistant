package com.example.healthassistant.ui.main

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.databinding.adapters.TextViewBindingAdapter.setTextSize
import com.example.healthassistant.R
import com.example.healthassistant.databinding.ActivityMainBinding
import com.github.mustafaozhan.basemob.activity.BaseVBActivity
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.bottom_navigation_view
import kotlinx.android.synthetic.main.activity_main.main_fab_btn
import javax.inject.Inject

class MainActivity : BaseVBActivity<ActivityMainBinding>(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun bind() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()

        setListeners()
        setDash()
    }

    private fun setListeners() {
        main_fab_btn.setOnClickListener {

        }
        main_fab_btn.setOnLongClickListener {

            true
        }

        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

            }
            true
        }
    }

    private fun setDash() = bottom_navigation_view.apply {
        inflateMenu(R.menu.bottom_menu)
        labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
    }

}
