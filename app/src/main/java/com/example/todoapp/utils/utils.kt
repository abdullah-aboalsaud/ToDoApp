package com.example.todoapp.utils

import android.content.Context

fun getCurrentDeviceLanguageCode(context: Context):String{
    return context.resources.configuration.locales[0].language
}