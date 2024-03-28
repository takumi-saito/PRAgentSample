package com.t.saito.pr_agent_sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class DemoViewModel(
    private val demoUseCase: DemoUseCase
) : ViewModel() {

    private val _pageFlag = MutableStateFlow<Boolean>(false)
    val pageFlag: SharedFlow<Boolean> get() = _pageFlag

    fun onClickAddItem() {
        demoUseCase.addItem("item")
    }
    fun onClickAddAllItems() {
        demoUseCase.addAllItem(listOf("item1", "item2", "item3"))
    }

    fun onClickFirstItem() {
        demoUseCase.firstItem()
    }

    fun onClickLastItem() {
        demoUseCase.lastItem()
    }

    fun onClickClear() {
        demoUseCase.clear()
    }

    fun onClickPageSwitch() {
        viewModelScope.launch {
            val pageFlag = _pageFlag.value
            _pageFlag.emit(pageFlag.not())
        }
    }
}

class DemoViewModelFactory(
    private val demoUseCase: DemoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DemoViewModel(
            demoUseCase = demoUseCase,
        ) as T
    }
}