package com.example.usecases

import com.example.data.repository.BackgroundsRepository

class GetListBackgroundsUseCase (private val backgroundsRepository: BackgroundsRepository) {

    suspend fun invoke(): List<String> = backgroundsRepository.getListBackgrounds()

}