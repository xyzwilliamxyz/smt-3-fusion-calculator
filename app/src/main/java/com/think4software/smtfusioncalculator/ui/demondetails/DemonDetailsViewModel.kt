package com.think4software.smtfusioncalculator.ui.demondetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.think4software.smtfusioncalculator.domain.interactor.GetDemonDetailsUseCase
import com.think4software.smtfusioncalculator.domain.model.Demon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DemonDetailsViewModel(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main,
    private val getDemonDetailsUseCase: GetDemonDetailsUseCase
): ViewModel() {

    private val _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState

    fun getDemonDetails(demonId: Int) {
        _screenState.value = ScreenState.Loading

        viewModelScope.launch(coroutineDispatcher) {
            val demon = getDemonDetailsUseCase.execute(demonId)
            _screenState.value = ScreenState.Success(demon)
        }
    }

    sealed class ScreenState {
        data class Success(val data: Demon): ScreenState()
        object Loading : ScreenState()
    }
}