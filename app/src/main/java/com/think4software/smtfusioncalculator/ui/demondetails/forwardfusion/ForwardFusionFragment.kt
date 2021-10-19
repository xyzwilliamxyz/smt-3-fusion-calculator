package com.think4software.smtfusioncalculator.ui.demondetails.forwardfusion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.think4software.smtfusioncalculator.databinding.FragmentForwardFusionBinding
import com.think4software.smtfusioncalculator.domain.model.ForwardFusion
import com.think4software.smtfusioncalculator.ui.demondetails.DemonDetailsActivity

class ForwardFusionFragment: Fragment() {
    private var _binding: FragmentForwardFusionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForwardFusionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelableArrayList<ForwardFusion>(ARGUMENT_FUSIONS)?.let {
            binding.forwardFusionList.adapter = ForwardFusionAdapter(requireContext(), it) { demonId ->
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

        fun getInstance(fusions: List<ForwardFusion>): Fragment {
            return ForwardFusionFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARGUMENT_FUSIONS, ArrayList(fusions))
                }
            }
        }
    }
}