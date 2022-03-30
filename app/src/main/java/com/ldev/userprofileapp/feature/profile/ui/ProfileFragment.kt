package com.ldev.userprofileapp.feature.profile.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.ldev.userprofileapp.R
import com.ldev.userprofileapp.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        binding.srlProfile.setOnRefreshListener {
            viewModel.processUiEvent(UiEvent.OnRefreshSwipe)
        }
    }

    private fun render(viewState: ViewState) {
        binding.apply {
            viewState.profile?.let {
                tvName.text = it.name
            }
            srlProfile.isRefreshing = viewState.isLoading
            viewState.errorMessage?.let {
                Snackbar.make(
                    binding.root,
                    viewState.errorMessage.toString(),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}