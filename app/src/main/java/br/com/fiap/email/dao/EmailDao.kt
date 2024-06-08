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
    suspend fun salvar(email: Email): Long

    @Update
    suspend fun atualizar(email: Email): Int

    @Delete
    suspend fun excluir(email: Email): Int

    @Query("SELECT * FROM tbl_emails ORDER BY remetente ASC")
    suspend fun listarTodosOsEmails(): List<Email>

    @Query("SELECT * FROM tbl_emails WHERE id = :id")
    suspend fun buscarEmailPeloId(id: Long): Email

    @Query("SELECT * FROM tbl_emails WHERE remetente LIKE :remetente ORDER BY remetente ASC")
    suspend fun getEmailsByRemetente(remetente: String): List<Email>
}
