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
import com.arlysfeitosa.convidados.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var mViewModel: AllGuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewModel = ViewModelProvider(this)
            .get(AllGuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all, container, false)

        //RecyclerView
        //1 - obter a recycler

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        //2 - definir um layout
        recycler.layoutManager = LinearLayoutManager(context)

        //3 - definir um adapter
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()

                bundle.putInt(GuestConstants.GUESTID, id)
                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onDelete(id: Int) {

                if(mViewModel.delete(id)){
                    Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Falha", Toast.LENGTH_SHORT).show()
                }

                mViewModel.load()
            }
        }

        mAdapter.attachListener(mListener)
        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }

    private fun observer() {
        //viewLifecycleOwner, variável do fragment q faz o papel de contexto
        mViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}