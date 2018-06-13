package com.hua.barmanager.demo.draglist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.support.v7.widget.helper.ItemTouchHelper
import com.hua.barmanager.R
import com.hua.barmanager.demo.DemoViewModel
import kotlinx.android.synthetic.main.activity_drag_list.*
import java.util.*


/**
 * Created by HUA on 2018/6/4.
 */
class DragListActivity : AppCompatActivity() {

    private lateinit var mAdapter : DragListAdapter
    private lateinit var mItemTouchHelper : ItemTouchHelper
    private lateinit var mModelList : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_list)

        initAdapter()

        initRecyclerView()

        initItemTouchHelper()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        //val layoutManager = GridLayoutManager(this, 7)

        //设置布局管理器
        drag_list.setLayoutManager(layoutManager)

        //设置为垂直布局，这也是默认的
        layoutManager.orientation = OrientationHelper.VERTICAL
        //设置Adapter
        drag_list.setAdapter(mAdapter)
        //设置分隔线
        //drag_list.addItemDecoration(DividerGridItemDecoration(this))
        //设置增加或删除条目的动画
        drag_list.setItemAnimator(DefaultItemAnimator())
    }

    private fun initAdapter() {
        val model = ViewModelProviders.of(this@DragListActivity).get(DemoViewModel::class.java)
        mModelList = model.getDemoListData()
        mAdapter = DragListAdapter(mModelList)
    }

    private fun initItemTouchHelper() {
        mItemTouchHelper = ItemTouchHelper(DragItemTouchHelper(drag_list,mModelList,mAdapter))
        mItemTouchHelper.attachToRecyclerView(drag_list)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        delegate.setTitle("DragList")
    }


}