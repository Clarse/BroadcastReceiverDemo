package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MessageReceiver : BroadcastReceiver() {

    private val TAG = "MessageReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        Log.d(TAG, "ACTION IS ---" + action)
        val stringExtra = intent?.getStringExtra(Constants.KEY_CONTENT)
        Log.d(TAG, "value is ---" + stringExtra)
    }

}