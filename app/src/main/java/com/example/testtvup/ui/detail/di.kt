package com.example.testtvup.ui.detail

import com.example.data.repository.FeedMoviesRepository
import com.example.usecases.FindMovieByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CatalogueDetailFragmentModule() {

    @Provides
    fun catalogueDetaillViewModelProvider(findMovieByIdUseCase: FindMovieByIdUseCase): CatalogueDetailViewModel {
        return CatalogueDetailViewModel(findMovieByIdUseCase)
    }

    @Provides
    fun findMovieByIdUseCase(feedMoviesRepository: FeedMoviesRepository) = FindMovieByIdUseCase(feedMoviesRepository)

}

@Subcomponent(modules = [CatalogueDetailFragmentModule::class])
interface CatalogueDetailFragmentComponent {
    val catalogueDetailViewModel: CatalogueDetailViewModel
}