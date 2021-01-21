package com.example.broadcastreceiverdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sendbroadcast.*

class SendBroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sendbroadcast)
    }

    //Android 8.0或更高版本，则无法使用清单为大多数隐式广播（广播不专门针对您的应用）声明接收器
    //所以我的临时解决方法就是声明我发送的这个intent是专门针对自己应用的   intent.setPackage("com.example.mybroadcast"); 接收器才得以正确接收到广播：
    fun sendBroadcast(view: View) {
        val intent = Intent()
        intent.action = Constants.ACTION_SEND_MSG
        intent.putExtra(Constants.KEY_CONTENT, send_content.text.toString())
        intent.setPackage("com.example.broadcastreceiverdemo")
        sendBroadcast(intent)
    }

}