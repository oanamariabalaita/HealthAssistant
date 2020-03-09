package com.example.healthassistant.utils.networkhandler

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.healthassistant.R
import com.example.healthassistant.utils.network.ErrorDialogConfig

open class ActivityNetworkErrorHandler : BaseNetworkErrorHandler(), IActivityNetworkErrorHandler {

    private lateinit var context: Context
    private lateinit var fragmentManager: FragmentManager

    override fun handleError(
        error: Throwable,
        requestCode: Int,
        config: ErrorDialogConfig
    ) {
        showErrorDialog(getMessageFromError(error))
    }

    override fun getContext(): Context = context

    override fun setFragmentManager(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    override fun setContext(context: Context) {
        this.context = context
    }

    override fun showErrorDialog(message: String) {
        ErrorDialogBehaviour.newInstance(
            message,
            config = ErrorDialogConfig(
                negativeButtonEnabled = false,
                positiveButtonEnabled = true,
                negativeButtonLocRes = null,
                positiveButtonLocRes = R.string.general_ok
            )
        ).show(fragmentManager, null)
    }
}