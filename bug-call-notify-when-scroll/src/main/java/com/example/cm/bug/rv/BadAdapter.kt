package com.example.cm.bug.rv

import android.annotation.SuppressLint
import android.os.Message
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_timer.view.*

/**
 * Created by 410063005 on 2018/5/25.
 */
class BadAdapter : RecyclerView.Adapter<BadTimerItemViewHolder>() {

    var timerItemList: List<TimerItem>? = null

    override fun onBindViewHolder(holder: BadTimerItemViewHolder?, position: Int) {
        holder?.bind(timerItemList?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BadTimerItemViewHolder {
        return BadTimerItemViewHolder(this, parent)
    }

    override fun getItemCount(): Int = timerItemList?.size ?: 0

    fun indexOf(item: TimerItem?): Int {
        return timerItemList?.indexOf(item) ?: 0
    }
}

class BadTimerItemViewHolder(private val adapter: BadAdapter, parent: ViewGroup?) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_timer, parent, false)) {

    private var counter: BadCounter? = null

    fun bind(item: TimerItem?) {
        itemView.tvTime.text = item?.time.toString()

        if (counter != null) {
            counter!!.stop()
        }
        counter = BadCounter(adapter, item)
        counter!!.start()

        adapter.notifyItemChanged(0)
    }
}

class BadCounter(private val adapter : BadAdapter, private val item: TimerItem?) {

    private val handler = @SuppressLint("HandlerLeak")
    object : android.os.Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

            if (item != null) {
                item.time -= 1

                if (item.time > 0) {
                    val pos = adapter.indexOf(item)
                    if (pos != -1) {
                        adapter.notifyItemChanged(pos)
                    }
                    sendEmptyMessageDelayed(0, 1000)
                }
            }
        }
    }

    fun stop() {
        handler.removeMessages(0)

        // 这里会引起 java.lang.IllegalStateException: Cannot call this method while RecyclerView is computing a layout or scrolling android.support.v7.widget.RecyclerView
        item?.time = 0
        adapter.notifyItemChanged(0)
    }

    fun start() {
        handler.sendEmptyMessageDelayed(0, 1000)
    }
}

fun foo() {
    val map = mapOf(1 to "a")
}

