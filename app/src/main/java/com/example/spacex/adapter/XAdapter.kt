package com.example.spacex.adapter

import SpaceBaseListModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.R
import kotlinx.android.synthetic.main.space_item.view.*

class XAdapter(val models: List<SpaceBaseListModel>) :
    RecyclerView.Adapter<XAdapter.SpaceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceViewHolder {
        return SpaceViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.space_item,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: SpaceViewHolder, position: Int) {
        holder.name.text = models[position].rocket_name
        holder.country.text = models[position].country
        holder.engineCount.text = models[position].first_stage.engines.toString()

    }

    class SpaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_name
        val country = itemView.tv_country
        val engineCount = itemView.tv_engine_count

    }
}

