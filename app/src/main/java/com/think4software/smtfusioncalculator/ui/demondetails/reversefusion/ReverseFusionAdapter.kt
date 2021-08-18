package com.think4software.smtfusioncalculator.ui.demondetails.reversefusion

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.think4software.smtfusioncalculator.core.extensions.applyOddOrEvenColor
import com.think4software.smtfusioncalculator.databinding.ReverseFusionItemBinding
import com.think4software.smtfusioncalculator.domain.model.ReverseFusion

class ReverseFusionAdapter(
    private val context: Context,
    private val fusions: List<ReverseFusion>,
    private val onItemClick: (demonId: Int) -> Unit
): RecyclerView.Adapter<ReverseFusionAdapter.ReverseFusionItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReverseFusionItemViewHolder {
        val binding = ReverseFusionItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ReverseFusionItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReverseFusionItemViewHolder, position: Int) {
        holder.bind(fusions[position], position)
    }

    override fun getItemCount(): Int {
        return fusions.size
    }

    inner class ReverseFusionItemViewHolder(private val binding: ReverseFusionItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(fusion: ReverseFusion, position: Int) {
            binding.ingredientOneRace.text = fusion.ingredientOne.race
            binding.ingredientOneLevel.text = fusion.ingredientOne.level.toString()
            binding.ingredientOneName.text = fusion.ingredientOne.name

            binding.ingredientTwoRace.text = fusion.ingredientTwo.race
            binding.ingredientTwoLevel.text = fusion.ingredientTwo.level.toString()
            binding.ingredientTwoName.text = fusion.ingredientTwo.name

            binding.root.applyOddOrEvenColor(position)

            binding.ingredientOne.setOnClickListener { onItemClick(fusion.ingredientOne.demonId) }
            binding.ingredientTwo.setOnClickListener { onItemClick(fusion.ingredientTwo.demonId) }
        }
    }
}