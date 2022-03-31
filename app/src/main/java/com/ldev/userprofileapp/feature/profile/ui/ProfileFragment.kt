package com.ldev.userprofileapp.feature.profile.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.ldev.userprofileapp.R
import com.ldev.userprofileapp.base.utils.loadImage
import com.ldev.userprofileapp.base.utils.setThrottledClickListener
import com.ldev.userprofileapp.base.utils.toStringFormat
import com.ldev.userprofileapp.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    companion object {
        private const val ZOOM_DEFAULT_MAP = 9
        fun newInstance() = ProfileFragment()
    }

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        binding.apply {
            srlProfile.setOnRefreshListener {
                viewModel.processUiEvent(UiEvent.OnRefreshSwipe)
            }
            llcPhone.setThrottledClickListener {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tvPhone.text}")))
            }
            llcCoordinates.setThrottledClickListener {
                viewModel.viewState.value?.profile?.let {
                    showMap(
                        latitude = it.coordinates.latitude,
                        longitude = it.coordinates.longitude
                    )
                }
            }
        }
    }

    private fun render(viewState: ViewState) {
        binding.apply {
            viewState.profile?.let {
                tvName.text = it.name
                ivPhoto.loadImage(it.picture, R.drawable.ic_account, R.drawable.ic_account)
                tvCity.text = it.city
                tvCountry.text = it.country
                tvPhone.text = it.phone
                tvStreet.text = it.street
                val coordinates = "${it.coordinates.latitude},${it.coordinates.longitude}"
                tvCoordinates.text = coordinates
                tvDateOfBirth.text = it.dateOfBirth.toStringFormat("dd.MM.yyyy")
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

    private fun showMap(latitude: Double, longitude: Double) {
        val gmmIntentUri = Uri.parse("geo:${latitude},${longitude}?z=${ZOOM_DEFAULT_MAP}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        try {
            startActivity(mapIntent)
        } catch (e: ActivityNotFoundException) {
            Snackbar.make(binding.root, R.string.map_error, Snackbar.LENGTH_SHORT).show()
        }
    }
}