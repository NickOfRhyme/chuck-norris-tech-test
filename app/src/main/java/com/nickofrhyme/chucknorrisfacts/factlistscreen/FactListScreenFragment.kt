package com.nickofrhyme.chucknorrisfacts.factlistscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nickofrhyme.chucknorrisfacts.databinding.FragmentFactListScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FactListScreen : Fragment() {


    private lateinit var binding: FragmentFactListScreenBinding
    private val viewModel: FactListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val includeExplicit = arguments?.getBoolean("includeExplicit") ?: false

        binding = FragmentFactListScreenBinding.inflate(inflater, container, false)

        val linearLayoutManager = LinearLayoutManager(context)

        binding.recyclerView.layoutManager = linearLayoutManager

        viewModel.jokeList.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = FactListRecyclerAdapter(viewModel.jokeList.value?.toList() ?: emptyList())
        }

        binding.loadMoreButton.setOnClickListener {
            viewModel.getJokes(includeExplicit)
        }

        return binding.root
    }
}