package com.hua.barmanager.demo.draglist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hua.barmanager.R


/**
 * Created by HUA on 2018/6/4.
 */
class DragListAdapter(private val demoListData: ArrayList<String>) : RecyclerView.Adapter<DragListAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemStr = demoListData[position]
        holder.contentTv.setText(itemStr)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_drag_list,parent,false))
    }

    override fun getItemCount(): Int {
        return demoListData.size
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val contentTv: TextView = itemView!!.findViewById(R.id.card_view_content)

    }
}