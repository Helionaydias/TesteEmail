package br.com.fiap.email.repository

import android.content.Context
import br.com.fiap.email.dao.EmailDb
import br.com.fiap.email.model.Email

class EmailRepository(context: Context) {

    private val db = EmailDb.getDataBase(context).emailDao()

    suspend fun salvar(email: Email): Long = db.salvar(email)

    suspend fun atualizar(email: Email): Int = db.atualizar(email)

    suspend fun listarTodosOsEmails(): List<Email> = db.listarTodosOsEmails()

    suspend fun buscarEmailPeloId(id: Long): Email = db.buscarEmailPeloId(id)

    suspend fun excluir(email: Email): Int = db.excluir(email)

    suspend fun getEmailsByRemetente(remetente: String): List<Email> = db.getEmailsByRemetente(remetente)
}
