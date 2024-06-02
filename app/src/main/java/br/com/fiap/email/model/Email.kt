package br.com.fiap.email.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_emails")
data class Email(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var remetente: String = "",
    var assunto: String = "",
    var detalhe: String = "",
    var imagem:String? = null,
    var data: String = "",
    var time: String = "",
    var isleia: Boolean = false


)
