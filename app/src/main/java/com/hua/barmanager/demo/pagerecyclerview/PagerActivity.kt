package com.hua.barmanager.demo.pagerecyclerview

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.hua.barmanager.R
import com.hua.barmanager.demo.DemoViewModel
import kotlinx.android.synthetic.main.activity_page.*
import java.util.*
import com.hua.barmanager.R.id.page_list




/**
 * Created by HUA on 2018/6/12.
 */
class PagerActivity : AppCompatActivity(){

    private lateinit var mAdapter : PagerAdapter
    private lateinit var mModelList : ArrayList<String>
    private lateinit var mSnapHelper : PagerSnapHelper
    private  var mChoseItemX = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        initAdapter()

        initRecyclerView()
    }

    private fun initAdapter() {
        val model = ViewModelProviders.of(this@PagerActivity).get(DemoViewModel::class.java)
        mModelList = model.getDemoListData()
        mAdapter = PagerAdapter(mModelList)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        //val layoutManager = GridLayoutManager(this, 7)

        //设置布局管理器
        page_list.setLayoutManager(layoutManager)

        //设置Adapter
        page_list.setAdapter(mAdapter)
        //设置分隔线
        //page_list.addItemDecoration(DividerGridItemDecoration(this))
        //设置增加或删除条目的动画
        page_list.setItemAnimator(DefaultItemAnimator())

        // add pager behavior
        mSnapHelper = PagerSnapHelper()
        mSnapHelper.attachToRecyclerView(page_list)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        delegate.setTitle("PagerActivity")
    }
}
