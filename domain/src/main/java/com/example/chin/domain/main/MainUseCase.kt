package com.example.chin.domain.main

import com.example.chin.domain.UseCase
import com.example.chin.domain.entities.ShoppingItem

interface MainUseCase: UseCase<String, List<ShoppingItem>>