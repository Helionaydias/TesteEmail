package br.com.fiap.email.componentes

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.email.R

@Composable
fun NovaMensagemFAB(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate("mensagem") },
        containerColor = Color(0xFFF00843),
        contentColor = Color.White,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
        modifier = Modifier.size(80.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.pencil),
            contentDescription = "Ícone Novo email",
            modifier = Modifier.size(24.dp)
        )
    }
}
