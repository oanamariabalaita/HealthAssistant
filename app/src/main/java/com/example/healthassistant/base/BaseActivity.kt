package com.example.healthassistant.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    protected lateinit var viewModel: VM

    @LayoutRes
    protected abstract fun getLayoutResId(): Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutResId()?.let {
            setContentView(it)
        }
    }

    protected fun setHomeAsUpEnabled(enabled: Boolean) =
        supportActionBar?.setDisplayHomeAsUpEnabled(enabled)

}