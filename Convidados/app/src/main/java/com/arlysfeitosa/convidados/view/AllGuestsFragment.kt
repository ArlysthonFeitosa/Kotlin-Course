package com.arlysfeitosa.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arlysfeitosa.convidados.R
import com.arlysfeitosa.convidados.service.constants.GuestConstants
import com.arlysfeitosa.convidados.view.adapter.GuestAdapter
import com.arlysfeitosa.convidados.view.listener.GuestListener
import com.arlysfeitosa.convidados.viewmodel.GuestsViewModel

class AllGuestsFragment : Fragment() {

    //View Model da fragment
    private lateinit var mViewModel: GuestsViewModel

    //Interface que fornece funções para override
    private lateinit var mListener: GuestListener

    //Adapter da Recycler View
    private val mAdapter: GuestAdapter = GuestAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {

        //Inicializando View Model
        mViewModel = ViewModelProvider(this)
            .get(GuestsViewModel::class.java)

        //Criação da fragment
        val root = inflater.inflate(R.layout.fragment_all, container, false)

        //RecyclerView
        //1 - obter a recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        //2 - definir um layout
        recycler.layoutManager = LinearLayoutManager(context)

        //3 - definir um adapter
        recycler.adapter = mAdapter

        //Listener para aplicar no adapter, assim, todas as funções serão aplicadas nos itens da recycler
        mListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)

                //Bundle, para adicionar valores em (key, value)
                val bundle = Bundle()

                bundle.putInt(GuestConstants.GUESTID, id)
                intent.putExtras(bundle) //Passando valor pela intent

                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.load(GuestConstants.FILTER.EMPTY)
            }
        }

        //Aplicando interface no adapter
        mAdapter.attachListener(mListener)
        observer()

        return root
    }

    //Depois de parar e voltar para a activity, incia o resume
    override fun onResume() {
        super.onResume()
        //Atualizando dados
        mViewModel.load(GuestConstants.FILTER.EMPTY)
    }

    private fun observer() {
        //viewLifecycleOwner, variável do fragment q faz o papel de contexto
        //Quando a lista de convidados atualizar, atualiza a lista
        mViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}