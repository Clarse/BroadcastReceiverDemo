package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AppStateChangeReceiver : BroadcastReceiver() {

    private val TAG = "AppStateChangeReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        if (Intent.ACTION_PACKAGE_ADDED == action) {
            Log.d(TAG, "应用安装了" + intent.data)
        } else if (Intent.ACTION_PACKAGE_REMOVED == action) {
            Log.d(TAG, "应用卸载了" + intent.data)
        }
    }

}