package com.arlysfeitosa.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arlysfeitosa.convidados.R
import com.arlysfeitosa.convidados.service.model.GuestModel
import com.arlysfeitosa.convidados.view.viewholder.GuestViewHolder

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList: List<GuestModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item)
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    fun updateGuests(list: List<GuestModel>) {
        mGuestList = list
        notifyDataSetChanged()
    }
}