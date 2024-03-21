package com.example.composenihal.utils

import com.orhanobut.logger.BuildConfig
import timber.log.Timber

fun timberLog(mTag: String, message: String) {
    if (BuildConfig.DEBUG) {
        Timber.tag(mTag).d(message)
    }
}