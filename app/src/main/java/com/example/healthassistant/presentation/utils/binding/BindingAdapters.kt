package com.example.healthassistant.presentation.utils.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.healthassistant.R

@BindingAdapter("enabled")
fun setEnabled(view: View, enabled: Boolean) {
    view.isEnabled = enabled
}

@BindingAdapter("visible")
fun setVisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter(
    "imageFromUrl",
    "placeholderImage",
    "imageRadius",
    "centerInsideScale",
    requireAll = false
)
fun bindImageFromUrl(
    view: ImageView,
    imageUrl: String?,
    placeholderImage: Drawable?,
    imageCornerRadius: Float?,
    centerInsideScale: Boolean?
) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply {
                if (imageCornerRadius != null) {
                    if (centerInsideScale == true) {
                        transform(CenterInside(), RoundedCorners(imageCornerRadius.toInt()))
                    } else {
                        transform(CenterCrop(), RoundedCorners(imageCornerRadius.toInt()))
                    }
                } else {
                    if (centerInsideScale == true) {
                        centerInside()
                    } else {
                        centerCrop()
                    }
                }
            }
            .placeholder(placeholderImage)
            .error(ContextCompat.getDrawable(view.context, R.drawable.ic_glide_error))
            .into(view)
    }
}
