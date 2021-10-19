package com.think4software.smtfusioncalculator.ui.skilllist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.think4software.smtfusioncalculator.core.extensions.applyOddOrEvenColor
import com.think4software.smtfusioncalculator.databinding.SkillListItemBinding
import com.think4software.smtfusioncalculator.domain.model.Skill

class SkillListAdapter(
    private val context: Context,
    private var skills: List<Skill> = listOf()
): ListAdapter<Skill, SkillListAdapter.SkillItemViewHolder>(
    DiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillListAdapter.SkillItemViewHolder {
        val binding = SkillListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return SkillItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SkillListAdapter.SkillItemViewHolder, position: Int) {
        holder.bind(skills[position], position)
    }

    override fun getItemCount(): Int {
        return skills.size
    }

    fun setData(newSkills: List<Skill>) {
        this.skills = newSkills
        submitList(newSkills)
    }

    private class DiffUtilItemCallback: DiffUtil.ItemCallback<Skill>() {
        override fun areItemsTheSame(oldItem: Skill, newItem: Skill): Boolean {
            return oldItem.skillId == newItem.skillId
        }

        override fun areContentsTheSame(oldItem: Skill, newItem: Skill): Boolean {
            return oldItem.name == newItem.name
        }
    }

    inner class SkillItemViewHolder(private val binding: SkillListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(skill: Skill, position: Int) {
            binding.element.setImageDrawable(ContextCompat.getDrawable(context, skill.element.drawable))
            binding.element.contentDescription = skill.element.description
            binding.name.text = skill.name
            binding.cost.text = skill.cost
            binding.effect.text = skill.effect
            binding.target.text = skill.target
            binding.inherit.text = skill.inherit.description
            binding.level.isVisible = false

            binding.root.applyOddOrEvenColor(position)
        }
    }
}
