package com.v2ray.ang.handler

import android.content.Context
import android.provider.Settings
import kotlinx.coroutines.*
import java.net.URL

object HwidManager {
    // Замени на URL своего сервера
    private const val CHECK_URL = "https://твой-сервер.com/check"

    fun check(context: Context) {
        val hwid = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        )
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = URL("$CHECK_URL?hwid=$hwid").readText()
                // response = "ok" если подписка активна
                // можно добавить логику блокировки если "denied"
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

