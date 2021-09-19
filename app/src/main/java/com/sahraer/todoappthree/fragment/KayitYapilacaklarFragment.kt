package com.sahraer.todoappthree.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.sahraer.todoappthree.R
import com.sahraer.todoappthree.databinding.FragmentKayitYapilacaklarBinding
import com.sahraer.todoappthree.entity.Yapilacaklar
import com.sahraer.todoappthree.factory.KayitYapilacaklarFragmentViewModelFactory
import com.sahraer.todoappthree.viewmodel.KayitYapilacaklarFragmentViewModel
import kotlinx.android.synthetic.main.fragment_kayit_yapilacaklar.view.*


class KayitYapilacaklarFragment : Fragment() {

    private lateinit var tasarim :FragmentKayitYapilacaklarBinding //binding bağlama
    private lateinit var viewModel:KayitYapilacaklarFragmentViewModel // viewmodel bağlama

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit_yapilacaklar, container, false)//binding bağlama
        tasarim.kayitYapilacaklarFragment = this
        tasarim.toolbarYapilacaklarBaslik = "Yapılacaklar İş Kayıt"








        return tasarim.root //binding bağlama
    }

    override fun onCreate(savedInstanceState: Bundle?) {//fragment viewmodel tanımlama-bağlama
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitYapilacaklarFragmentViewModel by viewModels(){
            KayitYapilacaklarFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonKaydetTikla(yapilacak_is:String){
        val yeniYapilacak = Yapilacaklar(0,yapilacak_is)
        viewModel.kayit(yeniYapilacak)
    }

}