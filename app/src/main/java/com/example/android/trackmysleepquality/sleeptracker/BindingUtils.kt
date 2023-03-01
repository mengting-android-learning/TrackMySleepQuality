package com.example.android.trackmysleepquality.sleeptracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight?) {
    item?.let {
        text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, context.resources)
    }
}

@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight?) {
    item?.let {
        text = convertNumericQualityToString(item.sleepQuality, context.resources)
    }
}

private const val VERY_BAD = 0

private const val POOR = 1

private const val SO_SO = 2

private const val OK = 3

private const val PRETTY_GOOD = 4

private const val EXCELLENT = 5

@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNight?) {
    item?.let {
        setImageResource(
            @Suppress("MagicNumber")
            when (item.sleepQuality) {
                VERY_BAD -> R.drawable.ic_sleep_0
                POOR -> R.drawable.ic_sleep_1
                SO_SO -> R.drawable.ic_sleep_2

                OK -> R.drawable.ic_sleep_3

                PRETTY_GOOD -> R.drawable.ic_sleep_4
                EXCELLENT -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_0
            }
        )
    }
}
