package com.example.healthassistant.base

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.databinding.ViewDataBinding
import com.example.healthassistant.R
import com.example.healthassistant.utils.extentions.hideKeyboard
import com.example.healthassistant.utils.isKeyboardShown
import com.example.healthassistant.utils.loading.ILoadingView
import com.example.healthassistant.utils.loading.LoadingHandler
import com.example.healthassistant.utils.permissions.FragmentPermissionsHandler
import com.example.healthassistant.utils.permissions.IFragmentPermissions

abstract class BaseDataBindingFragment<VB : ViewDataBinding> : BaseFragment(), BaseViewBinding<VB>,
    IFragmentPermissions,
    ILoadingView {

    private lateinit var viewBindingInternal: VB
    private val fragmentPermissionHandler = FragmentPermissionsHandler()
    private var lastKeyboardVisibilityState: Boolean = false
    protected val loadingHandler =
        LoadingHandler()

    override val viewBinding: VB
        get() = this.viewBindingInternal

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = createBinding(inflater, container).also {
        it.lifecycleOwner = viewLifecycleOwner
        viewBindingInternal = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onBind(viewBinding)
        viewBinding.executePendingBindings()
    }

    override fun onPause() {
        super.onPause()
        viewBinding.root.viewTreeObserver.removeOnGlobalLayoutListener(keyboardLayoutListener)
    }

    override fun onResume() {
        super.onResume()
        viewBinding.root.viewTreeObserver.addOnGlobalLayoutListener(keyboardLayoutListener)
    }


    override fun setFullScreenLoading(visible: Boolean): View? {
        if (visible) {
            context?.hideKeyboard(requireView().findFocus())
        }

        val visibleLoadingView = loadingHandler.setViewLoadingForView(
            viewBinding.root as ViewGroup,
            visible,
            loadingHandler.getDefaultLoadingView(layoutInflater)
        )

        if (visibleLoadingView != null) {
            val toolbar = getToolbar()
            if (toolbar != null) {
                val typedValue = TypedValue()
                val attrValid = requireContext().theme.resolveAttribute(
                    R.attr.actionBarSize,
                    typedValue,
                    false
                )
                val marginTop = if (attrValid) resources.getDimension(typedValue.data) else 0F
                val lp = visibleLoadingView.layoutParams as ViewGroup.MarginLayoutParams
                lp.setMargins(0, marginTop.toInt(), 0, 0)
                visibleLoadingView.layoutParams = lp
            }
        }
        return visibleLoadingView
    }

    override fun setViewLoading(parentView: ViewGroup, visible: Boolean): View? =
        loadingHandler.setViewLoadingForView(
            parentView,
            visible,
            loadingHandler.getDefaultLoadingView(layoutInflater)
        )

    private val keyboardLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
        val isOpen = if (activity != null) {
            isKeyboardShown(requireActivity().window.decorView)
        } else {
            false
        }

        if (isOpen != lastKeyboardVisibilityState) {
            if (isOpen) {
                onKeyboardShow()
            } else {
                onKeyboardHide()
            }
            lastKeyboardVisibilityState = isOpen
        }
    }


}
