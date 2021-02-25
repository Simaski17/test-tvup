package com.example.testtvup.ui.catalogue

import androidx.lifecycle.MutableLiveData
import com.example.domain.Backgrounds
import com.example.falabellatest.ui.common.*
import com.example.usecases.GetListBackgroundsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatalogueMainViewModel (private val getListBackgroundsUseCase: GetListBackgroundsUseCase) : ScopedViewModel() {

    val model = MutableLiveData<Data<List<Backgrounds>>>()

    init {
        initScope()
    }

    fun findBackground() {
        launch {
            model.postLoading()

            runCatching {
                withContext(Dispatchers.IO) {
                    getListBackgroundsUseCase.invoke()
                }
            }.onSuccess { response ->
                if (response.isNotEmpty()){
                    model.postValue(response)
                } else {
                    model.postException(Exception("${"Error"}: "))
                }

            }.onFailure { throwable ->
                model.postException(throwable)
            }

        }
    }

}