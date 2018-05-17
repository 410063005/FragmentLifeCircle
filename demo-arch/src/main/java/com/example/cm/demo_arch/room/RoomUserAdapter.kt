package com.example.cm.demo_arch.room

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cm.demo_arch.AppDatabaseHolder
import com.example.cm.demo_arch.R
import kotlinx.android.synthetic.main.item_room_list_all.view.*
import kotlin.concurrent.thread

/**
 * Created by 410063005 on 2018/5/16.
 */
class RoomUserAdapter(context: Context) : RecyclerView.Adapter<MyViewHolder>() {

    val userList: ArrayList<User> = ArrayList()
    var ctx: Context = context

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.itemView.ivDelete.setOnClickListener {

            val realPos = holder.adapterPosition
            if (realPos != RecyclerView.NO_POSITION) {
                thread {
                    AppDatabaseHolder.get(ctx).userDao().delete(userList[realPos])
                    holder.itemView.post {
                        userList.removeAt(realPos)
                        notifyItemRemoved(realPos)
                    }
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_room_list_all, parent, false))
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun bind(user: User) {
        itemView.tvFirstName.text = "${user.uid} ${user.firstName}"
        itemView.tvLastName.text = user.lastName
    }

}