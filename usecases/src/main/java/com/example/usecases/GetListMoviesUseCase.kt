package com.example.usecases

import com.example.data.repository.FeedMoviesRepository
import com.example.domain.ResponseIMDB

class GetListMoviesUseCase (private val feedMoviesRepository: FeedMoviesRepository) {

    suspend fun invoke(): List<ResponseIMDB> = feedMoviesRepository.getListMovies()

}