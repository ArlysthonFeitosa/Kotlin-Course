package com.example.tasks.service.listener

//Classe passada para activity
class ValidationListener(str: String = "") {

    private var mStatus: Boolean = true
    private var mMessage: String = ""

    //Ao inicializar a classe:
    init {
        //Se passaram alguma string, deu erro
        if(str !=  ""){
            mStatus = false
            mMessage = str
        }
    }

    fun success() = mStatus
    fun faliure() = mMessage
}