package com.example.chin.domain

import com.example.chin.domain.entities.ShoppingItem

interface ObtainListUseCase: UseCase<Unit, List<ShoppingItem>>
interface AddItemOrUpdateUseCase: UseCase<ShoppingItem, Unit>