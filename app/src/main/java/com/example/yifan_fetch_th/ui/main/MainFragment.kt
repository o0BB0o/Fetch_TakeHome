package com.example.yifan_fetch_th.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yifan_fetch_th.R
import com.example.yifan_fetch_th.database.Candidates
import kotlinx.android.synthetic.main.candidate_list.view.*
import androidx.lifecycle.Observer

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var candidatesRecycler: RecyclerView
    private lateinit var adapter: CandidatesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.parseJson()
        adapter=CandidatesAdapter()
        candidatesRecycler = view.findViewById(R.id.candidates_recycler)
        candidatesRecycler.layoutManager = LinearLayoutManager(context)
        candidatesRecycler.adapter = adapter
        viewModel.candidateList.observe(viewLifecycleOwner, Observer {
            adapter.updateWords(it)
        })
    }


    private inner class CandidatesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var candidates: Candidates
        private val id_Num: TextView = view.id_number
        private val listId_num: TextView = view.listid_number
        private val name: TextView = view.name_value

        fun bind(candidates: Candidates) {
            this.candidates = candidates
            id_Num.text = candidates.id.toString()
            listId_num.text = candidates.listId.toString()
            name.text = candidates.name
        }
    }

    private inner class CandidatesAdapter() : RecyclerView.Adapter<CandidatesViewHolder>() {
        var candidates: List<Candidates> = emptyList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidatesViewHolder {
            val view = layoutInflater.inflate(R.layout.candidate_list, parent, false)
            return CandidatesViewHolder(view)
        }

        override fun getItemCount() = candidates.size

        override fun onBindViewHolder(holder: CandidatesViewHolder, position: Int) {
            holder.bind(candidates[position])
        }

        fun updateWords(newCandidates: List<Candidates>) {
            this.candidates = newCandidates
        }
    }

}