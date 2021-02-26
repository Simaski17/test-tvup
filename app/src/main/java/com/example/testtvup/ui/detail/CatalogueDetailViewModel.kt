package com.example.testtvup.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.domain.Item
import com.example.domain.ResponseIMDB
import com.example.falabellatest.ui.common.*
import com.example.usecases.FindMovieByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatalogueDetailViewModel (private val findMovieByIdUseCase: FindMovieByIdUseCase): ScopedViewModel() {

    val model = MutableLiveData<Data<Item>>()

    init {
        initScope()
    }

    fun findMovieById(id: String) {
        launch {
            model.postLoading()

            runCatching {
                withContext(Dispatchers.IO) {
                    findMovieByIdUseCase.invoke(id)
                }
            }.onSuccess { response ->
                if (response != null){
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