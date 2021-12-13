package com.nickofrhyme.chucknorrisfacts.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nickofrhyme.chucknorrisfacts.databinding.FragmentMainScreenBinding


class MainScreen : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        binding.getjokebutton.setOnClickListener { openJokeDialog() }

        return binding.root
    }

    fun openJokeDialog() {
        val dialog = JokeDialogFragment()
        dialog.show(parentFragmentManager, "joke")
    }

}