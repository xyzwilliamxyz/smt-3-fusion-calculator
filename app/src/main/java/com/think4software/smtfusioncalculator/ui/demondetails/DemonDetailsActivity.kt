package com.think4software.smtfusioncalculator.ui.demondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.tabs.TabLayoutMediator
import com.think4software.smtfusioncalculator.R
import com.think4software.smtfusioncalculator.databinding.ActivityDemonDetailsBinding
import com.think4software.smtfusioncalculator.domain.model.Demon
import com.think4software.smtfusioncalculator.domain.model.DemonInheritances
import com.think4software.smtfusioncalculator.domain.model.DemonResistances
import com.think4software.smtfusioncalculator.domain.model.Skill
import org.koin.androidx.viewmodel.ext.android.viewModel

class DemonDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDemonDetailsBinding
    private val viewModel: DemonDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObservables()
        viewModel.getDemonDetails(intent.getIntExtra(ARGUMENT_DEMON_ID, 1))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setObservables() {
        viewModel.screenState.observe(this) {
            when (it) {
                is DemonDetailsViewModel.ScreenState.Success -> {
                    binding.container.isVisible = true
                    binding.loading.isVisible = false
                    setupViews(it.data)
                    binding.fusionsPager.adapter = DemonFusionPageAdapter(this, it.data)
                    setTabTitles()
                }
                is DemonDetailsViewModel.ScreenState.Loading -> {
                    binding.container.isVisible = false
                    binding.loading.isVisible = true
                }
            }
        }
    }

    private fun setupViews(demon: Demon) {
        setupToolbar(demon)
        setupStatsViews(demon)
        setupResistancesViews(demon.resistances)
        setupInheritanceViews(demon.inheritances)
        setupSkillsAdapter(demon.skills)
    }

    private fun setupToolbar(demon: Demon) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.demon_details_title_format).format(
            demon.race, demon.name, demon.level
        )
    }

    private fun setupStatsViews(demon: Demon) {
        binding.price.text = demon.price.toString()
        binding.hp.text = demon.hp.toString()
        binding.mp.text = demon.mp.toString()
        binding.st.text = demon.strength.toString()
        binding.ma.text = demon.magic.toString()
        binding.vi.text = demon.vitality.toString()
        binding.ag.text = demon.agility.toString()
        binding.lu.text = demon.luck.toString()
    }

    private fun setupResistancesViews(resistances: DemonResistances) {
        binding.physical.text = resistances.physical.abbreviation
        binding.fire.text = resistances.fire.abbreviation
        binding.ice.text = resistances.ice.abbreviation
        binding.electric.text = resistances.electric.abbreviation
        binding.force.text = resistances.force.abbreviation
        binding.expel.text = resistances.expel.abbreviation
        binding.death.text = resistances.death.abbreviation
        binding.mind.text = resistances.mind.abbreviation
        binding.nerve.text = resistances.nerve.abbreviation
        binding.curse.text = resistances.curse.abbreviation
    }

    private fun setupInheritanceViews(inheritances: DemonInheritances) {
        binding.inheritancesLabel.text = inheritances.asTokenizedString()
    }

    private fun setupSkillsAdapter(skills: List<Skill>) {
        binding.skillsList.adapter = DemonSkillListAdapter(this, skills)
    }

    private fun setTabTitles() {
        TabLayoutMediator(
            binding.tabLayout, binding.fusionsPager
        ) { tab, position ->
            tab.text = getString(TAB_TITLES[position])
        }.attach()
    }

    companion object {
        private val TAB_TITLES = arrayOf(R.string.tab_reverse_fusions, R.string.tab_forward_fusion)
        private const val ARGUMENT_DEMON_ID = "DEMON_ID"

        fun getIntent(context: Context, demonId: Int): Intent {
            return Intent(context, DemonDetailsActivity::class.java).apply {
                putExtra(ARGUMENT_DEMON_ID, demonId)
            }
        }
    }
}