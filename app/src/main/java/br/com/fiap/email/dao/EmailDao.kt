package br.com.fiap.email.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.email.model.Email

@Dao
interface EmailDao {

    @Insert
    fun salvar(email: Email): Long

    @Update
    fun atualizar(email: Email): Int

    @Delete
    fun excluir(email: Email): Int

    @Query("SELECT * FROM tbl_emails ORDER BY remetente ASC")
    fun listarTodosOsEmails(): List<Email>

    @Query("SELECT * FROM tbl_emails WHERE id = :id")
    fun buscarEmailPeloId(id: Long): Email
}