package com.nickofrhyme.chucknorrisfacts.factlistscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nickofrhyme.chucknorrisfacts.R

class FactListRecyclerAdapter(private val dataSet: List<String>) : RecyclerView.Adapter<FactListRecyclerAdapter.JokeViewHolder>()  {

    class JokeViewHolder(jokeView: View): RecyclerView.ViewHolder(jokeView) {
        val textView: TextView = jokeView.findViewById(R.id.tvFact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}