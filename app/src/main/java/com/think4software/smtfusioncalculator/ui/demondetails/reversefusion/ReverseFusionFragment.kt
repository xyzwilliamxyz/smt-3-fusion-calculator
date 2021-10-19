package com.think4software.smtfusioncalculator.ui.demondetails.reversefusion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.think4software.smtfusioncalculator.databinding.FragmentReverseFusionBinding
import com.think4software.smtfusioncalculator.domain.model.ReverseFusion
import com.think4software.smtfusioncalculator.ui.demondetails.DemonDetailsActivity

class ReverseFusionFragment: Fragment() {
    private var _binding: FragmentReverseFusionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReverseFusionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelableArrayList<ReverseFusion>(ARGUMENT_FUSIONS)?.let {
            binding.reverseFusionList.adapter = ReverseFusionAdapter(requireContext(), it) { demonId ->
                requireContext().startActivity(
                    DemonDetailsActivity.getIntent(requireContext(), demonId)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARGUMENT_FUSIONS = "ARGUMENT_FUSIONS"

        fun getInstance(fusions: List<ReverseFusion>): Fragment {
            return ReverseFusionFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARGUMENT_FUSIONS, ArrayList(fusions))
                }
            }
        }
    }
}