package com.example.testtvup.ui.catalogue

import com.example.data.repository.BackgroundsRepository
import com.example.data.repository.FeedMoviesRepository
import com.example.usecases.GetListBackgroundsUseCase
import com.example.usecases.GetListMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CatalogueMainFragmentModule() {

    @Provides
    fun catalogueMainViewModelProvider(getListMoviesUseCase: GetListMoviesUseCase, getListBackgroundsUseCase: GetListBackgroundsUseCase): CatalogueMainViewModel {
        return CatalogueMainViewModel(getListMoviesUseCase, getListBackgroundsUseCase) }

    @Provides
    fun getListBackgroundsUseCaseProvider(backgroundsRepository: BackgroundsRepository) = GetListBackgroundsUseCase(backgroundsRepository)

    @Provides
    fun getListMoviesUseCaseProvider(feedMoviesRepository: FeedMoviesRepository) = GetListMoviesUseCase(feedMoviesRepository)

}

@Subcomponent(modules = [CatalogueMainFragmentModule::class])
interface CatalogueMainFragmentComponent {
    val catalogueMainViewModel: CatalogueMainViewModel
}