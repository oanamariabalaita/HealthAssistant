package com.example.healthassistant.utils.networkhandler

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.healthassistant.R
import com.example.healthassistant.utils.network.ErrorDialogConfig

class ErrorDialogBehaviour : DialogFragment() {

    companion object {

        private const val MESSAGE_KEY = "messageKey"
        private const val CONFIG_KEY = "configKey"

        fun newInstance(message: String, config: ErrorDialogConfig) =
            ErrorDialogBehaviour().also {
                it.arguments = bundleOf(MESSAGE_KEY to message, CONFIG_KEY to config)
            }
    }

    init {
        isCancelable = false
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val arguments = requireArguments()

        val message = arguments.getString(MESSAGE_KEY)!!
        val config = arguments.getParcelable<ErrorDialogConfig>(CONFIG_KEY)!!

        val dialogBuilder =
            AlertDialog.Builder(requireContext(), R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
                .setTitle("ERROR")
                .setCancelable(false)
                .setMessage(message)

        if (config.negativeButtonEnabled) {
            val negativeLocRes = config.negativeButtonLocRes ?: "CANCEL"

            dialogBuilder.setNegativeButton(
                "NO"
            ) { _, _ ->
                targetFragment?.let {
                    it.onActivityResult(
                        targetRequestCode,
                        Activity.RESULT_CANCELED,
                        null
                    )
                }
            }
        }

        if (config.positiveButtonEnabled) {
            val positiveLocRes = config.positiveButtonLocRes ?: "RETRY"
            dialogBuilder.setPositiveButton(
                "OK"
            ) { _, _ ->
                targetFragment?.let {
                    it.onActivityResult(
                        targetRequestCode,
                        Activity.RESULT_OK,
                        null
                    )
                }
            }
        }

        return dialogBuilder.create()
    }

}