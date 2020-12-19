package com.arlysfeitosa.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arlysfeitosa.convidados.R
import com.arlysfeitosa.convidados.service.model.GuestModel
import com.arlysfeitosa.convidados.view.listener.GuestListener
import com.arlysfeitosa.convidados.view.viewholder.GuestViewHolder

//Adaptador da Recycler View - Herda um viewholder
class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    //lista de convidados
    private var mGuestList: List<GuestModel> = arrayListOf()
    private lateinit var mListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        //adiquirindo layout
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item, mListener) //Retornando uma view holder, com o layout e o listener
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    //Fazer ligação dos itens, passando a posição de cada item
    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    //Atribuindo a lista de convidados, para utilizar em outros métodos
    fun updateGuests(list: List<GuestModel>) {
        mGuestList = list
        notifyDataSetChanged()
    }

    //Atribuindo o interface de parâmetro na interface para outros métodos
    fun attachListener(listener: GuestListener){
        mListener = listener
    }
}