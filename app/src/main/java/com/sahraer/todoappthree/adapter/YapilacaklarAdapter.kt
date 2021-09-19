package com.sahraer.todoappthree.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sahraer.todoappthree.R
import com.sahraer.todoappthree.databinding.CardTasarimBinding
import com.sahraer.todoappthree.entity.Yapilacaklar
import com.sahraer.todoappthree.fragment.AnasayfaYapilacaklarFragment
import com.sahraer.todoappthree.fragment.AnasayfaYapilacaklarFragmentDirections
import com.sahraer.todoappthree.viewmodel.AnasayfaYapilacaklarFragmentViewModel

class YapilacaklarAdapter(var mContext:Context,var yapilacaklarListesi:List<Yapilacaklar>,var viewModel:AnasayfaYapilacaklarFragmentViewModel)
    :RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding)
        :RecyclerView.ViewHolder(cardTasarimBinding.root){//card işlemlerini bağlama ve tanımlama
        var cardTasarimBinding: CardTasarimBinding


        init {
           this.cardTasarimBinding = cardTasarimBinding //dışarıdan glen ve buradaki nesneyi birleştirdim
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        //cardtasarimı bağlama işlemi
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
       //tasarım üzerinde nasıl çalışma yapıldığının tanımlandığı yer
        val yapilacakbilgi = yapilacaklarListesi.get(position)
        val t = holder.cardTasarimBinding

        t.yapilacakNesnesi = yapilacakbilgi

        //cardview ile detay sayfasına geçiş yapmak
        t.cardViewSatir.setOnClickListener {
            //verilerin detay sayfasında gözükmesi
            val gecis = AnasayfaYapilacaklarFragmentDirections.detayYapilacakGecis(yapilacakbilgi)
            Navigation.findNavController(it).navigate(gecis)
        }
        //image erişim
        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${yapilacakbilgi.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                   viewModel.sil(yapilacakbilgi)
                }.show()
        }


    }

    override fun getItemCount(): Int {
       return yapilacaklarListesi.size
    }
}