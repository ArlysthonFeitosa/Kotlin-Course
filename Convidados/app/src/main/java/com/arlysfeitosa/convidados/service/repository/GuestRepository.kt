package com.arlysfeitosa.convidados.service.repository

import android.content.Context
import com.arlysfeitosa.convidados.service.model.GuestModel

//CRUD - Creat, Read, Update, Delete

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    //Singleton
    fun save(guest: GuestModel) {
        mGuestDataBaseHelper.writableDatabase
    }

    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun update(guest: GuestModel) {

    }

    fun delete(guest: GuestModel) {

    }

}