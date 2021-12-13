package com.nickofrhyme.chucknorrisfacts.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nickofrhyme.chucknorrisfacts.databinding.FragmentMainScreenBinding


class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        binding.getjokebutton.setOnClickListener { openJokeDialog() }

        return binding.root
    }

    private fun openJokeDialog() {
        val dialog = JokeDialogFragment()
//        viewModel.getJoke()
        dialog.show(parentFragmentManager, "joke")
    }

}