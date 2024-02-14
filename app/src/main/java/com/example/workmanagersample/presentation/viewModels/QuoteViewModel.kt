package com.example.workmanagersample.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workmanagersample.domain.models.ResultEntity
import com.example.workmanagersample.domain.usecase.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase
) : ViewModel() {

    private val _quoteList = MutableStateFlow<List<ResultEntity>?>(null)
    val quoteList = _quoteList as StateFlow<List<ResultEntity>?>

    fun getQuotes(page: Int) = getQuotesUseCase.invoke(
        viewModelScope,
        page,
        onSuccess = {
            // handle success
            viewModelScope.launch {
                it.collect { _quoteList.value = it }
            }
        },
        onFailure = {
            // handle error
        }
    )
}
