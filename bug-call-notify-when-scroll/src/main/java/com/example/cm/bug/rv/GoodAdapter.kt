package com.example.cm.bug.rv

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Message
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_timer.view.*

/**
 * Created by 410063005 on 2018/5/25.
 */
class GoodAdapter : RecyclerView.Adapter<GoodTimerItemViewHolder>() {

    var timerItemList: List<TimerItem>? = null

    override fun onBindViewHolder(holder: GoodTimerItemViewHolder?, position: Int) {
        holder?.bind(timerItemList?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GoodTimerItemViewHolder {
        return GoodTimerItemViewHolder(parent)
    }

    override fun getItemCount(): Int = timerItemList?.size ?: 0

}

class GoodCounter(private val text: TextView, private val item: TimerItem?) {

    private val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

            if (item != null) {
                item.time -= 1
                if (item.time >= 0) {
                    text.text = item.time.toString()
                    sendEmptyMessageDelayed(0, 1000)
                }
            }
        }
    }

    fun stop() {
        handler.removeMessages(0)

        // 这里会引起 java.lang.IllegalStateException: Cannot call this method while RecyclerView is computing a layout or scrolling android.support.v7.widget.RecyclerView
        item?.time = 0
        // adapter.notifyItemChanged(0)
        text.text = item?.time.toString()
    }

    fun start() {
        handler.sendEmptyMessageDelayed(0, 1000)
    }
}

class GoodTimerItemViewHolder(parent: ViewGroup?) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_timer, parent, false)) {

    private var counter: GoodCounter? = null

    fun bind(item: TimerItem?) {
        itemView.tvTime.text = item?.time.toString()

        if (counter != null) {
            counter!!.stop()
        }
        counter = GoodCounter(itemView.tvTime, item)
        counter!!.start()
    }
}

