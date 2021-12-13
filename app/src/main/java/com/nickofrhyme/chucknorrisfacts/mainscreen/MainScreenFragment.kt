package com.nickofrhyme.chucknorrisfacts.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nickofrhyme.chucknorrisfacts.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        binding.getJokeButton.setOnClickListener { openJokeDialog(viewModel.includeExplicit.value) }

        binding.explicitCheckBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.toggleExplicit(isChecked)
        }

        return binding.root
    }

    private fun openJokeDialog(includeExplicit: Boolean?) {
        val dialog = JokeDialogFragment()

        val args = Bundle()
        args.putBoolean("includeExplicit", includeExplicit ?: false)
        dialog.arguments = args

        dialog.show(parentFragmentManager, "joke")
    }


}