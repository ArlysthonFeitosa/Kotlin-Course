package com.arlysfeitosa.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import android.provider.ContactsContract
import android.text.Selection
import com.arlysfeitosa.convidados.service.constants.DataBaseConstants
import com.arlysfeitosa.convidados.service.model.GuestModel
import java.lang.Exception

//CRUD - Creat, Read, Update, Delete
//Singleton - só uma instância da classe GuestRepository ao mesmo tempo
//Private constructor, para ninguém instanciar a classe de qualquer canto

class GuestRepository private constructor(context: Context) {

    //Banco de dados
    private var mGuestDataBaseHelper = GuestDataBaseHelper(context)


    //Companion Object para inicializar o repositorio sem precisar inicializar a classe em si
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    //Pegar um convidado do banco de dados
    fun get(id: Int): GuestModel? {
        var guest: GuestModel? = null

        return try {
            //criando variavel para leitura do banco de dados
            val db = mGuestDataBaseHelper.readableDatabase

            //Array com as colunas existentes no banco de dados
            val projection: Array<String> = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )


            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection, selection,
                args, null,
                null, null
            )

            /*
            cursor:
            bancoDeDados.query(nome da tabela, array com as colunas, coluna de id =?, array com o id...)
             */

            //se o cursor não for nulo e seu contador for maior que 0
            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()

                //pegando dado do registro onde o cursor está posicionado
                val name =
                    cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                val presence =
                    (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)

                //retornando o GuestModel
                guest = GuestModel(id, name, presence)
            }
            //fechando o cursor obrigatoriamente
            cursor.close()

            guest
        } catch (exception: Exception) {
            guest
        }
    }

    //Salvar novos registros
    fun save(guest: GuestModel): Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            //ArrayMap de (key, value)
            val contentValues = ContentValues()

            //Inserindo pares de chave e valor para botar no banco
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            //Inserindo contentValues no banco
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true
        } catch (exception: Exception) {
            false
        }
    }

    //Pegar todos os registros
    fun getAll(): List<GuestModel> {

        //lista de convidados
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val projection: Array<String> = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection, null,
                null, null,
                null, null
            )

            if (cursor != null && cursor.count > 0) {

                //Enquanto der para ir para um próximo registo
                while (cursor.moveToNext()) {
                    //Pegando valores atuais do registro que o cursor aponta
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)

                    val guest = GuestModel(id, name, presence)
                    list.add(guest)
                }
            }
            cursor.close()

            list
        } catch (exception: Exception) {
            list
        }
    }

    //Selecionar apenas os presentes
    fun getPresent(): List<GuestModel> {

        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            //Outra forma de criar um cursor, onde o cursor passa por um filtro
            val cursor =
                db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 1", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)

                    val guest = GuestModel(id, name, presence)
                    list.add(guest)
                }
            }
            cursor.close()

            list
        } catch (exception: Exception) {
            list
        }
    }

    //Selecionando apenas ausentes
    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val cursor =
                db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 0", null)

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)

                    val guest = GuestModel(id, name, presence)
                    list.add(guest)
                }
            }
            cursor.close()

            list
        } catch (exception: Exception) {
            list
        }
    }

    //Atualizando registro de um convidado especidico
    fun update(guest: GuestModel): Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            //mapa com os dados novos do convidado
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)

            true
        } catch (exception: Exception) {
            false
        }
    }

    //Apagar convidado pelo id
    fun delete(id: Int): Boolean {
        return try {
            val db = mGuestDataBaseHelper.writableDatabase
            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
            true
        } catch (exception: Exception) {
            false
        }
    }
}