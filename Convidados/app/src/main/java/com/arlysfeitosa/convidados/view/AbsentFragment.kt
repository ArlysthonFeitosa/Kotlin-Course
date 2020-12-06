package com.arlysfeitosa.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arlysfeitosa.convidados.R
import com.arlysfeitosa.convidados.viewmodel.AbsentViewModel

class AbsentFragment : Fragment() {

    private lateinit var absentViewModel: AbsentViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        absentViewModel =
                ViewModelProvider(this).get(AbsentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_absent, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        absentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}