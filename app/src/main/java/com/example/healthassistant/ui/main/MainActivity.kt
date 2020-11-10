package com.example.healthassistant.ui.main

import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.healthassistant.R
import com.example.healthassistant.data.model.RedirectType
import com.example.healthassistant.databinding.ActivityMainBinding
import com.github.mustafaozhan.basemob.activity.BaseVBActivity
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseVBActivity<ActivityMainBinding>(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private lateinit var navController: NavController

    private val mainViewModel: MainViewModel by viewModels {
        defaultViewModelProviderFactory
    }

    override fun bind() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setListeners()
        setDash()
    }

    private fun setListeners() {
        binding.mainFabBtn.setOnClickListener {
        }
        binding.mainFabBtn.setOnLongClickListener {

            true
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val options = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
                .setPopUpTo(R.id.dashboardFragment, false)
                .build()

            try {
                navController.navigate(item.itemId, null, options)
            } catch (e: IllegalArgumentException) {
                return@setOnNavigationItemSelectedListener false
            }
            true
        }
    }

    private fun setDash() = binding.bottomNavigationView.apply {
        inflateMenu(R.menu.bottom_menu)
        labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
    }

    private fun handleRedirection(redirectType: RedirectType) {
        when (redirectType) {
            RedirectType.INTRO -> {
                navController.popBackStack(R.id.nav_graph, false) // Clear entire back stack
            }
            RedirectType.LOGGED_OUT -> {
                navController.popBackStack(R.id.nav_graph, false) // Clear entire back stack
            }
            RedirectType.DASHBOARD -> {
            }
        }
    }
}
