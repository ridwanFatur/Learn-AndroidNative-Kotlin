package com.ridwanproduction.learnandroidkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ridwanproduction.learnandroidkotlin.data.OperationCallback
import com.ridwanproduction.learnandroidkotlin.model.Museum
import com.ridwanproduction.learnandroidkotlin.model.MuseumRepository

class MuseumViewModel(private val repository: MuseumRepository) : ViewModel() {
    private val _museums = MutableLiveData<List<Museum>>().apply { value = emptyList() }
    val museums: LiveData<List<Museum>> = _museums

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    fun loadMuseums() {
        _isViewLoading.value = true
        repository.fetchMuseums(object : OperationCallback<Museum> {
            override fun onSuccess(data: List<Museum>?) {
                _isViewLoading.value = false
                if (data.isNullOrEmpty()) {
                    _isEmptyList.value = true
                } else {
                    _museums.value = data
                }
            }

            override fun onError(error: String?) {
                _isViewLoading.value = false
                _onMessageError.value = error
            }
        })
    }
}