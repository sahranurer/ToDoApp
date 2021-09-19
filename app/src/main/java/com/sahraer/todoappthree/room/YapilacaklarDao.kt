package com.sahraer.todoappthree.room

import androidx.room.*
import com.sahraer.todoappthree.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {

    @Query("SELECT * FROM yapilacaklar ")
    suspend fun tumYapilacaklar():List<Yapilacaklar>

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%' ")
    suspend fun yapilacakArama(aramaKelimesi:String):List<Yapilacaklar>

    @Insert
    suspend fun yapilacakEkle(yapilacakNesnesi:Yapilacaklar)

    @Update
    suspend fun yapilacakGuncelle(yapilacakNesnesi:Yapilacaklar)

    @Delete
    suspend fun yapilacakSil(yapilacakNesnesi:Yapilacaklar)



}