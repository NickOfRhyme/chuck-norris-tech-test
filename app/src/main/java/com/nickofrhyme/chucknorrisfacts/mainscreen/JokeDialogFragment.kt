package com.nickofrhyme.chucknorrisfacts.mainscreen

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JokeDialogFragment : DialogFragment() {

    private val viewModel: JokeDialogViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Here's your joke")
                .setNeutralButton("OK") { _, _ -> dismiss() }
            val dialog = builder.create()

            val jokeObserver = Observer<String> {newJoke ->
                dialog.setMessage(newJoke)
            }
            viewModel.joke.observe(this, jokeObserver)

            viewModel.getJoke()

            return dialog
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}