package com.example.healthassistant.ui.main

import com.example.healthassistant.databinding.ActivityMainBinding
import com.github.mustafaozhan.basemob.activity.BaseVBActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.mBottomNavigationView
import javax.inject.Inject

class MainActivity : BaseVBActivity<ActivityMainBinding>(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun bind() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }


    private fun setDash() = mBottomNavigationView.apply {
        //        inflateMenu(R.menu.bottom_menu)
//        enableAnimation(false)
//        labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
//        setTextSize(10.0f)
//        setIconsMarginTop(16)
//        itemTextColor = ColorStateList.valueOf(Color.WHITE)
//        setIconSize(32.0F, 32.0F)
//        getBottomNavigationItemView(1).background = null
//        getBottomNavigationItemView(2).background = null
//        getBottomNavigationItemView(3).background = null
//        getBottomNavigationItemView(2).isClickable = false
    }

}
