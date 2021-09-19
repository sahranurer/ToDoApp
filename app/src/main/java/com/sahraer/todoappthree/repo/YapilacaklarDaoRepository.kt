package com.sahraer.todoappthree.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sahraer.todoappthree.entity.Yapilacaklar
import com.sahraer.todoappthree.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var application: Application) {
    private val vt :Veritabani
    private val yapilacaklarListesi:MutableLiveData<List<Yapilacaklar>>

    init{
        vt = Veritabani.veritabaniErisim(application)!!
        yapilacaklarListesi = MutableLiveData()
    }

    fun yapilacaklariGetir():MutableLiveData<List<Yapilacaklar>>{
        return yapilacaklarListesi
    }

    fun tumYapilacaklariAl(){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
           yapilacaklarListesi.value =  vt.yapilacaklarDao().tumYapilacaklar()
        }

    }
    fun yapilacakAra(aramaKelimesi:String){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value =  vt.yapilacaklarDao().yapilacakArama(aramaKelimesi)
        }

    }
    fun yapilacakSil(yapilacaklar: Yapilacaklar){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
           vt.yapilacaklarDao().yapilacakSil(yapilacaklar)
            tumYapilacaklariAl()
        }

    }
    fun yapilacakKayit(yapilacaklar: Yapilacaklar){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.yapilacaklarDao().yapilacakEkle(yapilacaklar)

        }

    }
    fun yapilacakGuncelle(yapilacaklar: Yapilacaklar){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.yapilacaklarDao().yapilacakGuncelle(yapilacaklar)

        }

    }

}