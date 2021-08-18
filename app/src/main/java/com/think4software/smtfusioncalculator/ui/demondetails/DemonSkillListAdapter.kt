package com.think4software.smtfusioncalculator.ui.demondetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.think4software.smtfusioncalculator.core.extensions.applyOddOrEvenColor
import com.think4software.smtfusioncalculator.databinding.SkillListItemBinding
import com.think4software.smtfusioncalculator.domain.model.Skill

class DemonSkillListAdapter(
    private val context: Context,
    private val skills: List<Skill>,
): RecyclerView.Adapter<DemonSkillListAdapter.DemonSkillItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemonSkillItemViewHolder {
        val binding = SkillListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return DemonSkillItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DemonSkillListAdapter.DemonSkillItemViewHolder, position: Int) {
        holder.bind(skills[position], position)
    }

    override fun getItemCount(): Int {
        return skills.size
    }

    inner class DemonSkillItemViewHolder(private val binding: SkillListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(skill: Skill, position: Int) {
            binding.element.setImageDrawable(ContextCompat.getDrawable(context, skill.element.drawable))
            binding.element.contentDescription = skill.element.description
            binding.name.text = skill.name
            binding.cost.text = skill.cost
            binding.effect.text = skill.effect
            binding.target.text = skill.target
            binding.inherit.text = skill.inherit.description
            binding.level.text = skill.level

            binding.root.applyOddOrEvenColor(position)
        }
    }
}