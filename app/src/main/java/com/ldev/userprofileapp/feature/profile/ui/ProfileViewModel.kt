package com.ldev.userprofileapp.feature.profile.ui

import androidx.lifecycle.viewModelScope
import com.ldev.userprofileapp.feature.base.view_model.BaseViewModel
import com.ldev.userprofileapp.feature.base.view_model.Event
import com.ldev.userprofileapp.feature.profile.domain.ProfileInteractor
import kotlinx.coroutines.launch

class ProfileViewModel(private val interactor: ProfileInteractor) : BaseViewModel<ViewState>() {
    init {
        viewModelScope.launch {
            processDataEvent(DataEvent.GetData)
        }
    }

    override fun initialViewState() =
        ViewState(
            profile = null,
            isLoading = true,
            errorMessage = null
        )

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.GetData, UiEvent.OnRefreshSwipe -> {
                processDataEvent(DataEvent.LoadData(true))
                interactor.getProfile().fold(
                    onError = { processDataEvent(DataEvent.ErrorProfileRequest(it.localizedMessage)) },
                    onSuccess = { processDataEvent(DataEvent.SuccessProfileRequest(it)) }
                )
            }
            is DataEvent.SuccessProfileRequest -> {
                return previousState.copy(
                    profile = event.profile,
                    errorMessage = null,
                    isLoading = false
                )
            }
            is DataEvent.ErrorProfileRequest -> {
                return previousState.copy(
                    isLoading = false,
                    errorMessage = event.errorMessage
                )
            }
        }
        return null
    }
}