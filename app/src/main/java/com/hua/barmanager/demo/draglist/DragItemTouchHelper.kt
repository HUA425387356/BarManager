package com.hua.barmanager.demo.draglist

import android.graphics.Color
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import java.util.*

/**
 * Created by HUA on 2018/6/6.
 */
class DragItemTouchHelper : ItemTouchHelper.Callback {

    private val dragListView : RecyclerView
    private val  list :ArrayList<String>
    private val  mAdapter : RecyclerView.Adapter<DragListAdapter.MyViewHolder>

    constructor(dragList : RecyclerView,listData :ArrayList<String>,adapter : RecyclerView.Adapter<DragListAdapter.MyViewHolder>){
        dragListView = dragList
        list = listData
        mAdapter = adapter
    }

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        if (dragListView.layoutManager is GridLayoutManager) {
            //表格布局可以上下左右挪动
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            val swipeFlags = 0
            return makeMovementFlags(dragFlags, swipeFlags)
        } else {
            //线性布局只能上下挪动
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            val swipeFlags = 0
            return makeMovementFlags(dragFlags, swipeFlags)
        }
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        val fromPosition = viewHolder!!.adapterPosition//得到拖动ViewHolder的position
        val toPosition = target!!.adapterPosition//得到目标ViewHolder的position
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(list, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(list, i, i - 1)
            }
        }
        mAdapter.notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder!!.itemView.setBackgroundColor(Color.LTGRAY)
        }
        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?) {
        viewHolder!!.itemView.setBackgroundColor(0)
        super.clearView(recyclerView, viewHolder)
    }


}