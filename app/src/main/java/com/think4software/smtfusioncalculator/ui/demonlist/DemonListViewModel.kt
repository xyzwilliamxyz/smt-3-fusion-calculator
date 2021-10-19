package com.think4software.smtfusioncalculator.ui.demonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.think4software.smtfusioncalculator.domain.interactor.GetDemonsUseCase
import com.think4software.smtfusioncalculator.domain.model.Demon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DemonListViewModel(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main,
    private val getDemonsUseCase: GetDemonsUseCase
): ViewModel() {
    private val _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState

    fun getDemons() {
        _screenState.value = ScreenState.Loading

        viewModelScope.launch(coroutineDispatcher) {
            val demons = getDemonsUseCase.execute()
            _screenState.value = ScreenState.Success(demons)
        }
    }

    sealed class ScreenState {
        data class Success(val data: List<Demon>): ScreenState()
        object Loading : ScreenState()
    }
}
