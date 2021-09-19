package com.sahraer.todoappthree.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahraer.todoappthree.entity.Yapilacaklar
import com.sahraer.todoappthree.repo.YapilacaklarDaoRepository

class KayitYapilacaklarFragmentViewModel(application: Application): AndroidViewModel(application) {
    val yapilacaklarDaoRepo = YapilacaklarDaoRepository(application)
    fun kayit(yapilacaklar: Yapilacaklar){
        yapilacaklarDaoRepo.yapilacakKayit(yapilacaklar)
    }
}