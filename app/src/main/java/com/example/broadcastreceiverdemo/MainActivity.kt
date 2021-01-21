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
        lateinit var batterLevelReceiver: BatterLevelReceiver
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
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        //第三步
        //创建接受者
        batterLevelReceiver = BatterLevelReceiver()
        //第四步
        //动态注册广播
        registerReceiver(batterLevelReceiver, intentFilter)
    }

    /*
    * 第一步创建广播接受者。
    * */
    inner class BatterLevelReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action
            when {
                Intent.ACTION_BATTERY_CHANGED == action -> {

                    Log.d(TAG, intent?.action.toString())

                    val currentLevel = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                    Log.d(TAG, "当前电量：" + currentLevel)
                    batter_level.text = "当前电量：" + currentLevel

                    val maxLevel = intent?.getIntExtra(BatteryManager.EXTRA_SCALE, 0);

                    val i = maxLevel?.let { currentLevel?.times(1.0.div(it).times(100)) }

                    Log.d(TAG, "当前电量百分比：" + i + "%")
                }
                Intent.ACTION_POWER_CONNECTED == action -> {
                    Log.d(TAG, "usb 连接上了。。。")
                }
                Intent.ACTION_POWER_DISCONNECTED == action -> {
                    Log.d(TAG, "usb断开了。。。")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(batterLevelReceiver)
    }

}