package com.arlysfeitosa.convidados.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arlysfeitosa.convidados.R
import com.arlysfeitosa.convidados.service.model.GuestModel
import com.arlysfeitosa.convidados.view.listener.GuestListener

//ViewHolder, onde trata cada item da lista
class GuestViewHolder(itemView: View, private val listener: GuestListener) :
    RecyclerView.ViewHolder(itemView) {

    //Ligar item da lista com um Guest do banco de dados
    fun bind(guest: GuestModel) {

        //item da lista
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name //Atribuindo valor do guest para o item

        //Ao clicar no item
        textName.setOnClickListener {
            //Está com o override, na fragment
            listener.onClick(guest.id)
        }

        textName.setOnLongClickListener {
            val alert = AlertDialog.Builder(itemView.context)

            alert.setTitle(R.string.remocao_convidado)
            alert.setMessage(R.string.deseja_remover)
            alert.setPositiveButton(R.string.remover) { _, _ ->
                listener.onDelete(guest.id)
            }
            alert.setNeutralButton(R.string.cancelar, null)

            alert.show()
            true
        }
    }
}