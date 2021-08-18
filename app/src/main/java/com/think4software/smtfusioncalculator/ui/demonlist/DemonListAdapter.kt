package com.think4software.smtfusioncalculator.ui.demonlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.think4software.smtfusioncalculator.core.extensions.applyOddOrEvenColor
import com.think4software.smtfusioncalculator.databinding.DemonListItemBinding
import com.think4software.smtfusioncalculator.domain.model.Demon

class DemonListAdapter(
    private val context: Context,
    private val demons: List<Demon>,
    private val onItemClick: (demonId: Int) -> Unit
): RecyclerView.Adapter<DemonListAdapter.DemonItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemonListAdapter.DemonItemViewHolder {
        val binding = DemonListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return DemonItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DemonListAdapter.DemonItemViewHolder, position: Int) {
        holder.bind(demons[position], position)
    }

    override fun getItemCount(): Int {
        return demons.size
    }

    inner class DemonItemViewHolder(private val binding: DemonListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(demon: Demon, position: Int) {
            binding.race.text = demon.race
            binding.level.text = demon.level.toString()
            binding.name.text = demon.name

            binding.root.applyOddOrEvenColor(position)
            binding.root.setOnClickListener {
                onItemClick(demon.demonId)
            }
        }
    }
}