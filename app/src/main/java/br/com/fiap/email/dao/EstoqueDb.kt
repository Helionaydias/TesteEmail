package br.com.fiap.email.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.email.model.Email

//vai representar o banco de dados físico no sqlite,tem conhecer as operações qu vou executar no banco
@Database(entities = [Email::class],version = 2)//listar todas as classse que deverão ser entidades no banco
 abstract class EstoqueDb  : RoomDatabase(){


     abstract fun emailDao(): EmailDao

     //métodos estáticos
     companion object{
         //vai ser inicializada depois agora não
         private lateinit var instancia: EstoqueDb

         //sempre vai retorna a mesma instancia
         fun getDataBase(context: Context): EstoqueDb{

             //retorna um boobleano
             if(!::instancia.isInitialized){
                 instancia = Room
                     .databaseBuilder(
                         context,
                         EstoqueDb::class.java,
                         name = "estoque_db"
                     )
                     .allowMainThreadQueries()
                     .fallbackToDestructiveMigration()
                     .build()
             }
             return instancia

         }

     }

}