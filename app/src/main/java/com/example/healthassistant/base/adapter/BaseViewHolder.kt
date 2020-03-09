package com.example.healthassistant.base.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<out T, TViewBinding : ViewBinding>(
    protected val itemBinding: TViewBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    abstract fun bindItem(item: @UnsafeVariance T)
}