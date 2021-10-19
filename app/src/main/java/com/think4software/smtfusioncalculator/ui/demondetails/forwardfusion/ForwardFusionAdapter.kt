package com.think4software.smtfusioncalculator.ui.demondetails.forwardfusion

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.think4software.smtfusioncalculator.core.extensions.applyOddOrEvenColor
import com.think4software.smtfusioncalculator.databinding.ForwardFusionItemBinding
import com.think4software.smtfusioncalculator.databinding.ReverseFusionItemBinding
import com.think4software.smtfusioncalculator.domain.model.ForwardFusion
import com.think4software.smtfusioncalculator.domain.model.ReverseFusion

class ForwardFusionAdapter(
    private val context: Context,
    private val fusions: List<ForwardFusion>,
    private val onItemClick: (demonId: Int) -> Unit
) : RecyclerView.Adapter<ForwardFusionAdapter.ForwardFusionItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForwardFusionItemViewHolder {
        val binding = ForwardFusionItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ForwardFusionItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForwardFusionItemViewHolder, position: Int) {
        holder.bind(fusions[position], position)
    }

    override fun getItemCount(): Int {
        return fusions.size
    }

    inner class ForwardFusionItemViewHolder(
        private val binding: ForwardFusionItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(fusion: ForwardFusion, position: Int) {
            binding.ingredientTwoRace.text = fusion.ingredientTwo.race
            binding.ingredientTwoLevel.text = fusion.ingredientTwo.level.toString()
            binding.ingredientTwoName.text = fusion.ingredientTwo.name

            binding.resultRace.text = fusion.result.race
            binding.resultLevel.text = fusion.result.level.toString()
            binding.resultName.text = fusion.result.name

            binding.root.applyOddOrEvenColor(position)

            binding.ingredientTwo.setOnClickListener { onItemClick(fusion.ingredientTwo.demonId) }
            binding.result.setOnClickListener { onItemClick(fusion.result.demonId) }
        }
    }
}
