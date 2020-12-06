package com.arlysfeitosa.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arlysfeitosa.convidados.R
import com.arlysfeitosa.convidados.view.adapter.GuestAdapter
import com.arlysfeitosa.convidados.viewmodel.AllGuestsViewModel
import kotlinx.android.synthetic.main.fragment_all.*

class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: AllGuestsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        allGuestsViewModel = ViewModelProvider(this)
            .get(AllGuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all, container, false)

        //RecyclerView
        //1 - obter a recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        //2 - definir um layout
        recycler.layoutManager = LinearLayoutManager(context)

        //3 - definir um adapter
        recycler.adapter = GuestAdapter()

        return root
    }
}