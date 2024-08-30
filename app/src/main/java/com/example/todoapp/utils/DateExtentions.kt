package com.example.todoapp.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun Calendar.ignoreTime() {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}

fun Calendar.ignoreDate() {
    set(Calendar.DAY_OF_MONTH, 0)
    set(Calendar.MONTH, 0)
    set(Calendar.YEAR, 0)
}

fun Calendar.setDate(year: Int, month: Int, day: Int) {
    set(Calendar.YEAR, year)
    set(Calendar.MONTH, month)
    set(Calendar.DAY_OF_MONTH, day)
}

fun Calendar.setTime(hour: Int, minute: Int) {
    set(Calendar.HOUR_OF_DAY, hour)
    set(Calendar.MINUTE, minute)
}

fun Calendar.formatDateOnly(): String {
    val dateFormat = SimpleDateFormat("EEE, dd MM yyyy", Locale.ENGLISH)
    return dateFormat.format(time)
}

fun Calendar.formatTimeOnly(): String {
    val timeFormat = SimpleDateFormat("HH:mm a", Locale.getDefault())
    return timeFormat.format(time)
}

fun Long.formatTimeOnly(): String {
    val timeFormat = SimpleDateFormat("HH:mm a", Locale.getDefault())
    return timeFormat.format(this)
}
