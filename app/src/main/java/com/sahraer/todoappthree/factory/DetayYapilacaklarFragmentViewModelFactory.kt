package com.sahraer.todoappthree.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sahraer.todoappthree.viewmodel.DetayYapilacaklarFragmentViewModel

class DetayYapilacaklarFragmentViewModelFactory (private val application: Application)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetayYapilacaklarFragmentViewModel(application) as T
    }
}