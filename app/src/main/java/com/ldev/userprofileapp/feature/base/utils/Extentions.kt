package com.ldev.userprofileapp.feature.base.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.ldev.userprofileapp.R
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