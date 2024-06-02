package br.com.fiap.email.repository

import android.content.Context
import br.com.fiap.email.dao.EstoqueDb
import br.com.fiap.email.model.Email

class EmailRepository(context: Context) {

    //Conecta com o banco de dados
    //injetar o objeto que representa o banco de dados

    private val db = EstoqueDb.getDataBase(context).emailDao()


    fun salvar(email: Email): Long = db.salvar(email)

    fun atualizar(email: Email):Int{
        return  db.atualizar(email)
    }
    fun listarTodosOsEmails(): List<Email> {
        return db.listarTodosOsEmails()
    }
    fun buscarEmailPeloId(id: Long): Email = db.buscarEmailPeloId(id)

    fun excluir(email: Email): Int = db.excluir(email)






}