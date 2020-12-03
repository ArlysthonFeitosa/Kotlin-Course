package com.arlysfeitosa.convidados.service.repository

import com.arlysfeitosa.convidados.service.model.GuestModel

//CRUD - Creat, Read, Update, Delete

class GuestRepository {

    fun save(guest: GuestModel) {

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