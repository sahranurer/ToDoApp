package com.sahraer.todoappthree.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sahraer.todoappthree.viewmodel.AnasayfaYapilacaklarFragmentViewModel

class AnasayfaYapilacaklarFragmentViewModelFactory(private val application: Application)
    :ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AnasayfaYapilacaklarFragmentViewModel(application) as T
    }
}