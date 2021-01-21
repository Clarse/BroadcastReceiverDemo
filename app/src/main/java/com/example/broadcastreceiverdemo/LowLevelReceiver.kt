package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class LowLevelReceiver : BroadcastReceiver() {

    private val TAG = "LowLevelReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        Log.d(TAG, "low action is ---" + action)

        //修改广播内容
        val resultExtras = getResultExtras(true)
        val charSequence = resultExtras.getCharSequence(Constants.KEY_CONTENT)
        Log.d(TAG, "contant ---" + charSequence)

    }

}