package com.example.mvvmdemo.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R


class ResultAdapter(val context: Context, var results:List<Result> ): RecyclerView.Adapter<ResultAdapter.Resultviewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Resultviewholder {
        val manish = LayoutInflater.from(context).inflate(R.layout.result_view, parent, false)
        return Resultviewholder(manish)
    }

    override fun onBindViewHolder(holder: Resultviewholder, position: Int) {
        val man: Result = results[position]
        holder.result.text = man.content
    }

    override fun getItemCount(): Int {
        return results.size
    }


    class Resultviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var result = itemView.findViewById<TextView>(R.id.result)

    }

}

