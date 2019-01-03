package com.example.chin.domain.main

import com.example.chin.domain.UseCase
import com.example.chin.domain.entities.ShoppingItem

interface ObtainListUseCase: UseCase<Unit, List<ShoppingItem>>