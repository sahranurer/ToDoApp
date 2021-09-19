package com.sahraer.todoappthree.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sahraer.todoappthree.R
import com.sahraer.todoappthree.adapter.YapilacaklarAdapter
import com.sahraer.todoappthree.databinding.FragmentAnasayfaYapilacaklarBinding
import com.sahraer.todoappthree.entity.Yapilacaklar
import com.sahraer.todoappthree.factory.AnasayfaYapilacaklarFragmentViewModelFactory
import com.sahraer.todoappthree.viewmodel.AnasayfaYapilacaklarFragmentViewModel
import kotlinx.android.synthetic.main.fragment_anasayfa_yapilacaklar.view.*

class AnasayfaYapilacaklarFragment : Fragment() ,SearchView.OnQueryTextListener{

    private lateinit var tasarim:FragmentAnasayfaYapilacaklarBinding
    private lateinit var adapter: YapilacaklarAdapter
    private lateinit var viewModel:AnasayfaYapilacaklarFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim =  DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa_yapilacaklar, container, false)
        tasarim.toolbarYapilacaklarAnasayfaBaslik = "Yapılacaklar"
        tasarim.yapilacakAnasayfaFragment = this
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfaYapilacaklar)



        //recyclerView görünümünün nasıl olması gerektiğini tanımladığımız yer
        //tasarim.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //tasarim.recyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        //arayüzde tanımlanan yapilacaklar listesi




        //activity this,fragment lifecycleowner
        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner,{ yapilacaklarListesi ->
            adapter = YapilacaklarAdapter(requireContext(),yapilacaklarListesi,viewModel)
            tasarim.yapilacaklarAdapter = adapter

        })



        return tasarim.root
    }

    fun floatingActionButtonTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.kayitYapilacakGecis)
    }


    //menu işlemleri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:AnasayfaYapilacaklarFragmentViewModel by viewModels(){
            AnasayfaYapilacaklarFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)









        super.onCreateOptionsMenu(menu, inflater)
    }

    //menu seçim işlemleri
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_ara -> {
                //Toast.makeText(requireContext(),"Ara Tıklandı",Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        Log.e("Arama : tuşa basılınca",query)
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        Log.e("Arama : harf girdikçe",newText)
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }


}