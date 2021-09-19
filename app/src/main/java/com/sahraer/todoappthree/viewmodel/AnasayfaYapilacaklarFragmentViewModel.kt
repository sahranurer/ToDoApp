package com.sahraer.todoappthree.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sahraer.todoappthree.entity.Yapilacaklar
import com.sahraer.todoappthree.repo.YapilacaklarDaoRepository

class AnasayfaYapilacaklarFragmentViewModel(application: Application):AndroidViewModel(application) {
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()
    val yapilacaklarDaoRepo = YapilacaklarDaoRepository(application)

    init {
        yapilacaklariYukle()
        yapilacaklarListesi = yapilacaklarDaoRepo.yapilacaklariGetir()
    }

    fun yapilacaklariYukle(){
       yapilacaklarDaoRepo.tumYapilacaklariAl()
    }

    fun sil(yapilacaklar: Yapilacaklar){
        yapilacaklarDaoRepo.yapilacakSil(yapilacaklar)
    }
    fun ara(aramaKelimesi:String){
        yapilacaklarDaoRepo.yapilacakAra(aramaKelimesi)
    }


}