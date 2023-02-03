package com.example.yifan_fetch_th.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yifan_fetch_th.R

class SelectionFragment : Fragment() {

    companion object {
        fun newInstance() = SelectionFragment()
    }

    private lateinit var viewModel: SelectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SelectionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}