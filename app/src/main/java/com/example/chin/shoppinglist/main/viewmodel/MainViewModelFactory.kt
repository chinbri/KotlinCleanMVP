package com.example.chin.shoppinglist.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.navigator.Navigator
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val navigator: Navigator,
    private val obtainListUseCase: ObtainListUseCase,
    private val addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
): ViewModelProvider.Factory
{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            navigator, obtainListUseCase, addItemOrUpdateUseCase, deleteItemUseCase
        ) as T
    }

}