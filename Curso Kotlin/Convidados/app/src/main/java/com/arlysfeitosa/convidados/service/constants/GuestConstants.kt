package com.arlysfeitosa.convidados.service.constants


class GuestConstants private constructor() {
    companion object {
        const val GUESTID = "guestID"
    }

    //Dados para serem utilizados em um filtro de presença
    object FILTER {
        const val EMPTY = 0
        const val PRESENT = 1
        const val ABSENT = 2
    }
}