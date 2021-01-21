package com.example.broadcastreceiverdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SendOrderBroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_order_broadcast)
    }

    fun sendOrderBroadcast(view: View) {
        val intent = Intent()
        intent.action = Constants.ACTION_SEND_ORDER_BROADCAST
        intent.setPackage("com.example.broadcastreceiverdemo")
        val bundle = Bundle()
        bundle.putCharSequence(Constants.KEY_CONTENT, "我是被发送的内容")
        sendOrderedBroadcast(intent, Manifest.permission.ORDER_PERMISSION, null, null, RESULT_OK, null, bundle)
    }

}