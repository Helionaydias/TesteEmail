package br.com.fiap.email.componentes



import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.model.Email
import br.com.fiap.email.repository.EmailRepository
import br.com.fiap.email.ui.theme.PoppinsBold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MensagemTopBar(
    navController: NavController,
    scrollBehavior: TopAppBarScrollBehavior,
    coroutineScope: CoroutineScope,
    emailRepository: EmailRepository,
    subject: String,
    message: String
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xff253746),
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                "Nova mensagem",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF5F6F7),
                fontFamily = PoppinsBold
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigate("caixadeentrada") }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Ícone fechar mensagem",
                    tint = Color(0xFFF5F6F7),
                )
            }
        },
        actions = {
            IconButton(onClick = {
                coroutineScope.launch {
                    val email = Email(
                        remetente = "seu_email@dominio.com",
                        assunto = subject,
                        detalhe = message,
                        imagem = null,
                        data = "2024-06-04",
                        time = "10:00",
                        isleia = false
                    )
                    emailRepository.salvar(email)
                    navController.navigate("caixadeentrada")
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.enviar),
                    contentDescription = "Ícone enviar mensagem",
                    tint = Color(0xFF30CAE3),
                    modifier = Modifier.size(width = 20.dp, height = 16.dp)
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}
