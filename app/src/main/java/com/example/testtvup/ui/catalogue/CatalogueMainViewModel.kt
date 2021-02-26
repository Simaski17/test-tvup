package com.example.testtvup.ui.catalogue

import androidx.lifecycle.MutableLiveData
import com.example.domain.Backgrounds
import com.example.domain.ResponseIMDB
import com.example.falabellatest.ui.common.*
import com.example.usecases.GetListBackgroundsUseCase
import com.example.usecases.GetListMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatalogueMainViewModel (private val getListMoviesUseCase: GetListMoviesUseCase, private val getListBackgroundsUseCase: GetListBackgroundsUseCase) : ScopedViewModel() {

    val model = MutableLiveData<Data<List<Backgrounds>>>()
    val modelData = MutableLiveData<Data<List<ResponseIMDB>>>()

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

    fun findMovies() {
        launch {
            modelData.postLoading()

            runCatching {
                withContext(Dispatchers.IO) {
                    getListMoviesUseCase.invoke()
                }
            }.onSuccess { response ->
                if (response.isNotEmpty()){
                    modelData.postValue(response)
                } else {
                    model.postException(Exception("${"Error"}: "))
                }

            }.onFailure { throwable ->
                modelData.postException(throwable)
            }

        }
    }

}