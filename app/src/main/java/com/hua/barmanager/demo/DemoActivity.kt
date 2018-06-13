package com.hua.barmanager.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hua.barmanager.R
import com.hua.barmanager.demo.draglist.DragListActivity
import com.hua.barmanager.demo.pagerecyclerview.PagerActivity
import kotlinx.android.synthetic.main.activity_demo.*

/**
 * Created by HUA on 2018/6/4.
 */
class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        drag_list.setOnClickListener({ dragList() })
        view_page_home.setOnClickListener({ viewPageHome() })
        other.setOnClickListener({ other() })
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        delegate.setTitle("Demo")
    }

    private fun dragList() {
        val intent  = Intent(this, DragListActivity::class.java)
        this.startActivity(intent)
    }

    private fun viewPageHome() {
        val intent  = Intent(this, PagerActivity::class.java)
        this.startActivity(intent)
    }

    private fun other() {
    }
}