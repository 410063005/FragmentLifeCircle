package com.example.cm.bug_bottomsheetdialog

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rv_item_province.view.*

/**
 * Created by 410063005 on 2018/5/11.
 */
class ProvinceAdapter : RecyclerView.Adapter<ProvinceViewHolder>() {

    var provinceList : List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        return ProvinceViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_province, parent, false))
    }

    override fun getItemCount(): Int {
        return provinceList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(provinceList?.get(position))
    }
}

class ProvinceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(provinceName: String?) {
        itemView.tvProvince.text = provinceName
    }
}