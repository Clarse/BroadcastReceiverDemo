package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver()

    }

    private fun registerReceiver() {
        //第二步：
        //我们要收听的频道：电量变化
        val intentFilter = IntentFilter()
        //设置频道
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        //第三步
        //创建接受者
        val batterLevelReceiver = BatterLevelReceiver()
        //第四步
        //动态注册广播
        registerReceiver(batterLevelReceiver, intentFilter)
    }

    /*
    * 第一步创建广播接受者。
    * */
    inner class BatterLevelReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d(TAG, intent?.action.toString())
            Log.d(TAG, "当前电量：" + intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0))
            batter_level.text = "当前电量：" + intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        }
    }

}