package com.ldev.userprofileapp.feature.base.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.ldev.userprofileapp.R
import com.ldev.userprofileapp.feature.base.constants.Constants
import java.text.SimpleDateFormat
import java.util.*

fun ImageView.loadImage(
    src: String?,
    @DrawableRes errorRes: Int = R.drawable.ic_image_not_supported,
    @DrawableRes placeholderRes: Int = R.drawable.ic_image_not_supported,
    config: RequestBuilder<Drawable>.() -> Unit = {}
) {
    Glide
        .with(context)
        .load(src)
        .error(errorRes)
        .placeholder(placeholderRes)
        .apply { config(this) }
        .into(this)
}

fun String.toDate(dataFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS"): Date {
    val calendar = Calendar.getInstance()
    val parser = SimpleDateFormat(dataFormat, Locale.getDefault())
    parser.parse(this)?.let { calendar.time = it }
    if (calendar == Calendar.getInstance()) calendar.timeInMillis = 0L
    return calendar.time
}

fun Date.toStringFormat(format: String = "dd.MM.yyyy HH:mm"): String {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    return formatter.format(this)
}

fun View.setThrottledClickListener(
    delay: Long = Constants.DEFAULT_THROTTLE_DELAY,
    onClick: (View) -> Unit
) {
    setOnClickListener {
        throttle(delay) {
            onClick(it)
        }
    }
}

private var lastClickTimestamp = 0L
fun throttle(delay: Long = Constants.DEFAULT_THROTTLE_DELAY, action: () -> Unit): Boolean {
    val currentTimestamp = System.currentTimeMillis()
    val delta = currentTimestamp - lastClickTimestamp
    if (delta !in 0L..delay) {
        lastClickTimestamp = currentTimestamp
        action()
        return true
    }
    return false
}