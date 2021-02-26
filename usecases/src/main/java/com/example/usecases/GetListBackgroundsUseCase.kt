package com.example.usecases

import com.example.data.repository.BackgroundsRepository
import com.example.domain.Backgrounds

class GetListBackgroundsUseCase (private val backgroundsRepository: BackgroundsRepository) {

    suspend fun invoke(): List<Backgrounds> = backgroundsRepository.getListBackgrounds()

}