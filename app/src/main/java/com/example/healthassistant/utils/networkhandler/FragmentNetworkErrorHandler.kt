package com.example.healthassistant.utils.networkhandler

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.healthassistant.R
import com.example.healthassistant.utils.network.ErrorDialogConfig

open class FragmentNetworkErrorHandler : BaseNetworkErrorHandler(), IFragmentNetworkErrorHandler {

    private lateinit var fragment: Fragment

    override fun handleError(
        error: Throwable,
        requestCode: Int,
        config: ErrorDialogConfig
    ) {
        ErrorDialogBehaviour
            .newInstance(getMessageFromError(error), config)
            .also { it.setTargetFragment(fragment, requestCode) }
            .show(fragment.parentFragmentManager, null)
    }

    override fun getContext(): Context = fragment.requireContext()

    override fun setFragment(fragment: Fragment) {
        this.fragment = fragment
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
        ).show(fragment.childFragmentManager, null)
    }

    protected fun getFragment() = fragment
}