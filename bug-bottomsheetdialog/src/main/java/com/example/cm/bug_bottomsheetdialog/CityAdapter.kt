package com.example.cm.bug_bottomsheetdialog

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rv_item_city.view.*

/**
 * Created by 410063005 on 2018/5/11.
 */
class CityAdapter : RecyclerView.Adapter<CityViewHolder>() {
    var cityList: List<String>? = null

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList?.get(position))
    }

    override fun getItemCount(): Int {
        return cityList?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_city, parent, false))
    }

}

class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(cityName: String?) {
        itemView.tvCity.text = cityName
    }
}