package com.example.usecases

import com.example.data.repository.FeedMoviesRepository
import com.example.domain.Item
import com.example.domain.ResponseIMDB

class FindMovieByIdUseCase (private val feedMoviesRepository: FeedMoviesRepository) {
    suspend fun invoke(id: String): Item = feedMoviesRepository.findMovieById(id)
}