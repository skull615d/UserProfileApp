package com.ldev.userprofileapp.feature.profile.ui

import com.ldev.userprofileapp.base.view_model.Event
import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel

data class ViewState(
    val profile: ProfileDomainModel?,
    val isLoading: Boolean,
    val errorMessage: String?
)

sealed class UiEvent : Event {
    object OnRefreshSwipe : UiEvent()
}

sealed class DataEvent : Event {
    object GetData : DataEvent()
    data class SuccessProfileRequest(val profile: ProfileDomainModel?) : DataEvent()
    data class ErrorProfileRequest(val errorMessage: String?) : DataEvent()
    data class LoadData(val isLoading: Boolean) : DataEvent()
}