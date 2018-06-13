package com.hua.barmanager

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hua.barmanager.demo.DemoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test_hello.setOnClickListener({ testHello() })
    }

    private fun testHello() {
        //打开测试界面
        val intent  = Intent(this, DemoActivity::class.java)
        this.startActivity(intent)
    }
}
