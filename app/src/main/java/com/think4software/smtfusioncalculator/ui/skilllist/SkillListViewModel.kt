package com.think4software.smtfusioncalculator.ui.skilllist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.think4software.smtfusioncalculator.domain.interactor.GetSkillsUseCase
import com.think4software.smtfusioncalculator.domain.model.Skill
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SkillListViewModel(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main,
    private val getSkillsUseCase: GetSkillsUseCase
): ViewModel() {
    private val _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState

    fun getSkills() {
        _screenState.value = ScreenState.Loading

        viewModelScope.launch(coroutineDispatcher) {
            val skills = getSkillsUseCase.execute()
            _screenState.value = ScreenState.Success(skills)
        }
    }

    sealed class ScreenState {
        data class Success(val data: List<Skill>): ScreenState()
        object Loading : ScreenState()
    }
}
