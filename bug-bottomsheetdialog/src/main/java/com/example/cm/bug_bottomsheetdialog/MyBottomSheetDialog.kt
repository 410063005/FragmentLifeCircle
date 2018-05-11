package com.example.cm.bug_bottomsheetdialog

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my_bottom_dialog.view.*

/**
 * Created by 410063005 on 2018/5/11.
 */
class MyBottomSheetDialog : BottomSheetDialogFragment() {
    var count = 0

    private val cityList = listOf(
            generateSequence { (count++).toString().takeIf { count < 100 } }.toList(),
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "10", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"),
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "10", "12", "13", "14", "15", "16", "17", "18")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_bottom_dialog, container, false)

        val provinceAdapter = ProvinceAdapter()
        provinceAdapter.provinceList = listOf("广东", "广西", "湖北", "福建", "湖南", "浙江", "山东", "海南", "山西", "北京", "上海",
                "广东", "广西", "湖北", "福建", "湖南", "浙江", "山东", "海南", "山西", "北京", "上海",
                "广东", "广西", "湖北", "福建", "湖南", "浙江", "山东", "海南", "山西", "北京", "上海",
                "广东", "广西", "湖北", "福建", "湖南", "浙江", "山东", "海南", "山西", "北京", "上海")
        view.rvProvince.adapter = provinceAdapter
        view.rvProvince.layoutManager = LinearLayoutManager(context)

        val cityAdapter = CityAdapter()
        cityAdapter.cityList = cityList[0]
        view.rvCity.adapter = cityAdapter
        view.rvCity.layoutManager = GridLayoutManager(context, 4)

        return view
    }
}