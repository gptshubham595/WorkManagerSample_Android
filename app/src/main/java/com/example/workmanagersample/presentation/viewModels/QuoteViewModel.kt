package com.example.workmanagersample.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workmanagersample.domain.models.ResultEntity
import com.example.workmanagersample.domain.usecase.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
) : ViewModel() {

    private val _quoteList = MutableLiveData<List<ResultEntity>>()
    val quoteList = _quoteList as LiveData<List<ResultEntity>>

    fun getQuotes(page: Int) = getQuotesUseCase.invoke(
        viewModelScope,
        page,
        onSuccess = {
            // handle success
            viewModelScope.launch {
                it.collect { _quoteList.postValue(it) }
            }
        },
        onFailure = {
            // handle error
        },
    )
}
