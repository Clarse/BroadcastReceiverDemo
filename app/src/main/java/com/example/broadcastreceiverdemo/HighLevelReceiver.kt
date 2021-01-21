package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class HighLevelReceiver : BroadcastReceiver() {
    private val TAG = "HighLevelReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        Log.d(TAG, "high action is ---" + action)

        //终止往下传送
        //abortBroadcast()

        //修改广播内容
        val resultExtras = getResultExtras(true)
        val charSequence = resultExtras.getCharSequence(Constants.KEY_CONTENT)
        Log.d(TAG, "contant ---" + charSequence)
        resultExtras.putCharSequence(Constants.KEY_CONTENT, "我是被修改的内容")
        setResultExtras(resultExtras)

    }

}