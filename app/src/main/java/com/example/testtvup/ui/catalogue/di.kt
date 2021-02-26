package com.example.testtvup.ui.catalogue

import com.example.data.repository.BackgroundsRepository
import com.example.usecases.GetListBackgroundsUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CatalogueMainFragmentModule() {

    @Provides
    fun catalogueMainViewModelProvider(getListBackgroundsUseCase: GetListBackgroundsUseCase): CatalogueMainViewModel {
        return CatalogueMainViewModel(getListBackgroundsUseCase) }

    @Provides
    fun getListBackgroundsUseCaseProvider(backgroundsRepository: BackgroundsRepository) = GetListBackgroundsUseCase(backgroundsRepository)

}

@Subcomponent(modules = [CatalogueMainFragmentModule::class])
interface CatalogueMainFragmentComponent {
    val catalogueMainViewModel: CatalogueMainViewModel
}