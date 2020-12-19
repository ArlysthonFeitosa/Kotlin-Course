package com.arlysfeitosa.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import android.provider.ContactsContract
import android.text.Selection
import com.arlysfeitosa.convidados.service.constants.DataBaseConstants
import com.arlysfeitosa.convidados.service.model.GuestModel
import java.lang.Exception


class GuestRepository(context: Context) {

    //Banco de dados
    private val mDataBase = GuestDataBase.getDataBase(context).guestDAO()

    //Pegar um convidado do banco de dados
    fun get(id: Int): GuestModel {
        return mDataBase.get(id)
    }

    //Salvar novos registros
    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    //Pegar todos os registros
    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    //Selecionar apenas os presentes
    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }

    //Selecionando apenas ausentes
    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    //Atualizando registro de um convidado especidico
    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0
    }

    //Apagar convidado pelo id
    fun delete(guest: GuestModel){
        mDataBase.delete(guest)
    }
}