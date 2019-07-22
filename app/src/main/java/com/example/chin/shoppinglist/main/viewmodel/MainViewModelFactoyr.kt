package com.example.chin.shoppinglist.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.navigator.Navigator
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val obtainListUseCase: ObtainListUseCase,
                                               val addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
                                               val deleteItemUseCase: DeleteItemUseCase
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            obtainListUseCase,
            addItemOrUpdateUseCase,
            deleteItemUseCase)
                as T
    }
}