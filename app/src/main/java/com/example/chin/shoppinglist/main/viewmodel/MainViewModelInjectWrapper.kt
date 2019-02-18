package com.example.chin.shoppinglist.main.viewmodel

import com.example.chin.domain.AddItemOrUpdateUseCase
import com.example.chin.domain.DeleteItemUseCase
import com.example.chin.domain.ObtainListUseCase
import com.example.chin.navigator.Navigator
import javax.inject.Inject

class MainViewModelInjectWrapper @Inject constructor(
    private val mainViewModel: MainViewModel,
    private val navigator: Navigator,
    private val obtainListUseCase: ObtainListUseCase,
    private val addItemOrUpdateUseCase: AddItemOrUpdateUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
) {
    var initalized = false

    fun obtainViewModel(): MainViewModel{
        if(!initalized){
            mainViewModel.initialize(navigator, obtainListUseCase, addItemOrUpdateUseCase, deleteItemUseCase)
            initalized = true
        }
        return mainViewModel

    }

}