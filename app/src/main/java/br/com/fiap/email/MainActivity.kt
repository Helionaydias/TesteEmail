package br.com.fiap.email

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.email.screens.CadastroScreen
import br.com.fiap.email.screens.CaixaDeEntradaScreen
import br.com.fiap.email.screens.InicialScreen
import br.com.fiap.email.screens.LoginScreen
import br.com.fiap.email.screens.MensagemScreen
import br.com.fiap.email.screens.PerfilScreen
import br.com.fiap.email.ui.theme.EmailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {



                    val navController = rememberNavController()


                    NavHost(
                        navController = navController,
                        startDestination = "inicial"

                    ){
                        composable(route = "inicial") { InicialScreen(navController) }
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "cadastro") { CadastroScreen(navController) }
                        composable(route = "caixadeentrada"){CaixaDeEntradaScreen(navController)}
                        composable(route = "menucaixadeentrada"){PerfilScreen(navController)}
                        composable(route = "mensagem"){ MensagemScreen(navController, this@MainActivity)}
                    }
                }
            }
        }
    }
}

