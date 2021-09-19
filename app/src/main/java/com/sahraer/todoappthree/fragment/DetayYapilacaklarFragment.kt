package com.sahraer.todoappthree.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sahraer.todoappthree.R
import com.sahraer.todoappthree.databinding.FragmentDetayYapilacaklarBinding
import com.sahraer.todoappthree.entity.Yapilacaklar
import com.sahraer.todoappthree.factory.DetayYapilacaklarFragmentViewModelFactory
import com.sahraer.todoappthree.viewmodel.DetayYapilacaklarFragmentViewModel
import kotlinx.android.synthetic.main.fragment_detay_yapilacaklar.*
import kotlinx.android.synthetic.main.fragment_detay_yapilacaklar.view.*


class DetayYapilacaklarFragment : Fragment() {
private lateinit var tasarim : FragmentDetayYapilacaklarBinding
private lateinit var viewModel:DetayYapilacaklarFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay_yapilacaklar, container, false)
     tasarim.toolbarYapilacaklarDetayBaslik = "Yapılacaklar İş Detay"
        tasarim.yapilacakDetayFragment = this

        //verileri alıp edittexte yazdırma işlemleri
        val bundle:DetayYapilacaklarFragmentArgs by navArgs()
        val gelenYapilacakis = bundle.isNesnesi
        tasarim.yapilacakNesnesi = gelenYapilacakis





        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayYapilacaklarFragmentViewModel by viewModels(){
            DetayYapilacaklarFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonguncelleTikla(yapilacak_id:Int,yapilacak_is:String){
        val guncelYapilacak = Yapilacaklar(yapilacak_id,yapilacak_is)
       viewModel.guncelle(guncelYapilacak)
    }

}