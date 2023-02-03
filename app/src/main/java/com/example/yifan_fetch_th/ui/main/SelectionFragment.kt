package com.example.yifan_fetch_th.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yifan_fetch_th.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment() {

    companion object {
        fun newInstance() = SelectionFragment()
        var passedValue: Int = 0
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

        ListID1.setOnClickListener() {
            passedValue = 1
            val action =
                SelectionFragmentDirections.actionSelectionFragmentToMainFragment(1)
            findNavController().navigate(action)
        }

        ListID2.setOnClickListener() {
            passedValue = 2
            val action =
                SelectionFragmentDirections.actionSelectionFragmentToMainFragment(2)
            this.findNavController().navigate(action)
        }

        ListID3.setOnClickListener() {
            passedValue = 3
            val action =
                SelectionFragmentDirections.actionSelectionFragmentToMainFragment(3)
            this.findNavController().navigate(action)
        }

        ListID4.setOnClickListener() {
            passedValue = 4
            val action =
                SelectionFragmentDirections.actionSelectionFragmentToMainFragment(4)
            findNavController().navigate(action)
        }

        all_button.setOnClickListener() {
            passedValue = 0
            val action =
                SelectionFragmentDirections.actionSelectionFragmentToMainFragment(0)
            findNavController().navigate(action)
        }
    }

}