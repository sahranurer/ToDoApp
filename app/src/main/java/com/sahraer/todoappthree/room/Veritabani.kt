package com.sahraer.todoappthree.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sahraer.todoappthree.entity.Yapilacaklar
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Yapilacaklar::class],version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun yapilacaklarDao():YapilacaklarDao

    companion object {
        var INSTANCE :Veritabani? = null

        fun veritabaniErisim(context: Context):Veritabani?{
            if (INSTANCE == null){
                kotlin.synchronized(Veritabani::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        Veritabani::class.java,"isler.sqlite").createFromAsset("isler.sqlite").build()
                }
            }
            return INSTANCE
        }


    }

}